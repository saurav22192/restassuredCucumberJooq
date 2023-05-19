Feature: homepage
@HomePage @ui
Scenario: Validating the homepage 1
Given User opens the google website
When  User is on home page
Then User should be able to enter the search key "Roses" in the search box

  @HomePage @ui
Scenario: Validating the homepage 2
Given User opens the google website
When  User is on home page
Then User should be able to enter the search key "Roses" in the search box
#  //Serialization enables us to save the state of an object and recreate the object in a new location

#Cucumber does not support Inheritance means it does not allow extending classes that contain Step Definitions or Hooks (@After, @Before, etc.). Now, Dependency Injection comes into the picture.
#
#In Cucumber, if we want to share the state between multiple-step definition files, we will need to use dependency injection (DI).
#A dependency injection is a strategy that is used to separate the creation of dependency objects from the class that needs them.
#  happens at runtime
  #When class A uses some functionality of class B, then its said that class A has a dependency of class B.
  #
  #In Java, before we can use methods of other classes, we first need to create the object of that class (i.e. class A needs to create an instance of class B).
  #
  #So, transferring the task of creating the object to someone else and directly using the dependency is called dependency injection.

#There are basically three types of dependency injection:
#constructor injection: the dependencies are provided through a class constructor.
#setter injection: the client exposes a setter method that the injector uses to inject the dependency.
#interface injection: the dependency provides an injector method that will inject the dependency into any client passed to it. Clients must implement an interface that expo
#ses a setter method that accepts the dependency.


  #Why should I use dependency injection?
  #Let’s say we have a car class which contains various objects such as wheels, engine, etc.
  #
  #Here the car class is responsible for creating all the dependency objects. Now, what if we decide to ditch MRFWheels in the future and want to use Yokohama Wheels?
  #
  #We will need to recreate the car object with a new Yokohama dependency. But when using dependency injection (DI), we can change the Wheels at runtime (because dependencies can be injected at runtime rather than at compile time).
  #
  #You can think of DI as the middleman in our code who does all the work of creating the preferred wheels object and providing it to the Car class.
  #
  #It makes our Car class independent from creating the objects of Wheels, Battery, etc.
  #https://www.freecodecamp.org/news/a-quick-intro-to-dependency-injection-what-it-is-and-when-to-use-it-7578c84fa88f/


#  I think a lot of times people get confused about the difference between dependency injection and a dependency injection framework (or a container as it is often called).
#
#Dependency injection is a very simple concept. Instead of this code:
#
#public class A {
#  private B b;
#
#  public A() {
#    this.b = new B(); // A *depends on* B
#  }
#
#  public void DoSomeStuff() {
#    // Do something with B here
#  }
#}
#
#public static void Main(string[] args) {
#  A a = new A();
#  a.DoSomeStuff();
#}
#you write code like this:
#
#public class A {
#  private B b;
#
#  public A(B b) { // A now takes its dependencies as arguments
#    this.b = b; // look ma, no "new"!
#  }
#
#  public void DoSomeStuff() {
#    // Do something with B here
#  }
#}
#
#public static void Main(string[] args) {
#  B b = new B(); // B is constructed here instead
#  A a = new A(b);
#  a.DoSomeStuff();
#}
#And that's it. Seriously. This gives you a ton of advantages. Two important ones are the ability to control functionality from a central place (the Main() function) instead of spreading it throughout your program, and the ability to more easily test each class in isolation (because you can pass mocks or other faked objects into its constructor instead of a real value).
#
#The drawback, of course, is that you now have one mega-function that knows about all the classes
#  @user962206 think about how you would test A independently from B –
#jk.
# Jan 13, 2013 at 14:12
#81
#@user962206, also, think about what would happen if B needed some parameters in its constructor: in order to instantiate it, A would have to know about those parameters, something that might be completely unrelated to A (it just wants to depend on B, not on what B depends on). Passing an already constructed B (or any subclass or mock of B for that matter) to A's constructor solves that and makes A depend only on B :)