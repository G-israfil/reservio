package reservio.common.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;


@Component
public class JwtUtils {

    private static final String CLAIM_USERNAME = "username";
    private static final String CLAIM_EMAIL = "email";
    private static final String CLAIM_ROLES = "roles";
    private static final String CLAIM_RESTAURANTS = "restaurants";
    private static final String CLAIM_ACCOUNT = "accounts";


    @Value("${app.jwt-secret}")
    private String secret;

    @NonNull
    public String createTokenWithDuration(
            @NonNull final Long id,
            @NonNull final String username,
            @NonNull final String email,
            @NonNull final String roles,
            @NonNull final String restaurants,
            @NonNull final String accounts,
            @NonNull final int timeoutDuration)
            throws UnsupportedEncodingException {

        return JWT.create()
                .withSubject(String.valueOf(id))
                .withClaim(CLAIM_USERNAME, username)
                .withClaim(CLAIM_EMAIL,email)
                .withClaim(CLAIM_ROLES,roles)
                .withClaim(CLAIM_RESTAURANTS,restaurants)
                .withClaim(CLAIM_ACCOUNT,accounts)
                .withExpiresAt(
                        Date.from(
                                LocalDateTime.now()
                                        .plusMinutes(timeoutDuration)
                                        .atZone(ZoneId.systemDefault())
                                        .toInstant()))
                .sign(Algorithm.HMAC512(secret));
    }

    @NonNull
    public String verifyAndExtractUsername(@NonNull final String authHeader) {

        return this.verifyAndDecode(this.getToken(authHeader)).getClaim(CLAIM_USERNAME).asString();
    }

    @NonNull
    public String verifyAndExtractEmail(@NonNull final String authHeader) {

        return this.verifyAndDecode(this.getToken(authHeader)).getClaim(CLAIM_EMAIL).asString();
    }

    @NonNull
    public List<String> verifyAndExtractRestaurants(@NonNull final String authHeader) {
        return Arrays.stream(this.verifyAndDecode(this.getToken(authHeader)).getClaim(CLAIM_RESTAURANTS).asString().split(",")).toList();
    }

    @NonNull
    public List<String> verifyAndExtractAccounts(@NonNull final String authHeader) {
        return Arrays.stream(this.verifyAndDecode(this.getToken(authHeader)).getClaim(CLAIM_ACCOUNT).asString().split(",")).toList();
    }

    @NonNull
    public Long extractUserId(@NonNull final String authHeader) {
        return this.getUserId(this.getToken(authHeader));
    }

    @NonNull
    public List<String> extractRoles(@NonNull final String authHeader) {
        final String rolesString = this.getRoles(this.getToken(authHeader));

        return Arrays.stream(rolesString.split(",")).toList();
    }

    public String getRoles(@NonNull final String token){
        return this.verifyAndDecode(token).getClaim(CLAIM_ROLES).asString();
    }

    @NonNull
    public Long getUserId(@NonNull final String token) {

        return Long.parseLong(this.verifyAndDecode(token).getSubject());
    }

    @NonNull
    private DecodedJWT verifyAndDecode(@NonNull final String token) {
        final DecodedJWT decodedJWT;

        try {
            decodedJWT = JWT.require(Algorithm.HMAC512(this.secret)).build().verify(token);
        } catch (final TokenExpiredException e) {
            throw new RuntimeException("sessionExpired");
        } catch (final JWTVerificationException e) {
            throw new RuntimeException("accessNotAllowed");
        }

        return decodedJWT;
    }

    @NonNull
    private String getToken(@NonNull final String authHeader) {

        if (!authHeader.contains("Bearer")) {

            throw new RuntimeException("accessNotAllowed");
        }

        return authHeader.replaceFirst("^Bearer ", "");
    }

    public void verify(@NonNull final String authHeader) {

        this.isTokenExpired(this.getToken(authHeader));
    }

    public void isTokenExpired(@NonNull final String token) {

        try {
            JWT.require(Algorithm.HMAC512(this.secret)).build().verify(token);
        } catch (final TokenExpiredException e) {
            throw new RuntimeException("sessionExpired");
        } catch (final JWTVerificationException e) {
            throw new RuntimeException("accessNotAllowed");
        }
    }

    /** We need to return a different error string to make refresh token mechanism to work */
    public void isRefreshTokenExpired(@NonNull final String token) {

        try {
            JWT.require(Algorithm.HMAC512(this.secret)).build().verify(token);
        } catch (final TokenExpiredException e) {
            throw new RuntimeException("refreshTokenExpired");
        } catch (final JWTVerificationException e) {
            throw new RuntimeException("accessNotAllowed");
        }
    }
}
