# LSP VS ISP

### Liskov Substitution Principle

* This principle make sure that all child classes have the same behavior as the parent class.
*   **Problem code →** Here we are forcing client to use extra method of `upiPayment()` in every card which doesn’t even support it.

    ```java
    interface CreditCard {
        boolean swipeAndPay();
    		void upiPayment();
    }

    class MasterCard implements CreditCard {
        @Override
        public boolean swipeAndPay();
    		// Violation -> Master Card doesn't support UPI Payment
    		public void upiPayment(); // We need to throw exception here

    }

    class RuPay implements CreditCard {
        @Override
    		// Both are supported here
        public boolean swipeAndPay()
        public void upiPayment()
    }
    ```
*   **Solution code**

    ```java
    interface CreditCard {
        boolean swipeAndPay();
    }

    // Separate interface for UPI functionality
    interface UpiPaymentMethod {
        void upiPayment();
    }

    interface MasterCard extends CreditCard {
    	@Override
    	public boolean swipeAndPay();
    }

    // RuPay Card can now correctly implements upi payment without voilation
    interface RuPayCard extends CreditCard, UpiPaymentMethod {
        @Override
        public boolean swipeAndPay();

        @Override
        public void upiPayment();
    }
    ```

***

### Interface Segragtion Principle

* This Principle create a different interface for different responsibilities.
* If there is common responsibility in all implementation then only keep it in same interface.
* In other words, don't group unrelated behavior in one interface, You break ISP if You have already an interface with many responsibilities, and the implementor doesn't need all this stuff.
*   P**roblem Code** → Some Credit Card doesn’t support _UPI Payment_ and with some credit card we cannot take _loan_. _Here we need segregation_

    ```java
    interface CreditCard {
    	void swipeAndPay();
    	void Loan();
    	void upiPayment();
    }
    ```
*   **Solution Code →** We can keep the common function in Credit Card. and Optional function in seperate interface.

    ```java
    interface CreditCard {
    	void swipeAndPay();
    }

    interface LoanMethod extends CreditCard {
        void Loan();
    }

    interface UpiPaymentMethod extends CreditCard {
    	void upiPayment();
    }
    ```
*   **Solution Code (Alternative Method) →** Or we can make seperate interface for everything.

    ```java
    interface swipeAndPayMethod {
        void swipeAndPay();
    }

    interface LoanMethod {
        void Loan();
    }

    interface UpiPaymentMethod {
        void upiPayment();
    }
    ```

***

### Difference

| Feature        | LSP (Liskov Substitution Principle)   | ISP (Interface Segregation Principle)     |
| -------------- | ------------------------------------- | ----------------------------------------- |
| Focus          | Subtype behavior                      | Client-interface dependency               |
| Relationship   | Subclasses and superclasses           | Clients and interfaces                    |
| Violation      | Subtype breaks contract of superclass | Client forced to depend on unused methods |
| Goal           | Ensure substitutability               | Reduce coupling                           |
| Implementation | Inheritance hierarchies               | Interface refinement                      |
