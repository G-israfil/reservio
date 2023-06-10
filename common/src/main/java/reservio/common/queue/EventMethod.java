package reservio.common.queue;

@FunctionalInterface
public interface EventMethod {

  void run(EventMessage eventMessage);
}