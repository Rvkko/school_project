# Initialize an empty dictionary to store expenses categorized by type
expenses = {}

# Function to display the main menu and return the user's choice
def display_menu():
    print("\nExpense Tracker Menu:")
    print("1. Add an expense")
    print("2. Show summary")
    print("3. Exit")
    return input("Enter your choice: ")

# Function to add an expense
def add_expense():
    try:
        # Prompt the user for the expense amount
        amount = float(input("Enter the expense amount: "))
        category = input("Enter the category for this expense: ")
        
        # Check if the category already exists in the dictionary
        if category in expenses:
            expenses[category] += amount  # Add the amount to the existing total
        else:
            expenses[category] = amount  # Create a new category and set the amount

        print("Expense added successfully!")  # Confirmation message
    except ValueError:
        print("Invalid amount. Please enter a number.")  # Handle invalid input for amount

# Function to display the summary of expenses
def show_summary():
    if not expenses:  # Check if the dictionary is empty
        print("No expenses recorded yet.")  # Inform the user if no expenses exist
    else:
        total = sum(expenses.values())  # Calculate the total expenses
        print(f"\nTotal Expenses: ${total:.2f}")
        print("Breakdown by category:")
        for category, amount in expenses.items():
            print(f"{category}: ${amount:.2f}")

# Main program loop
while True:
    choice = display_menu()  # Display the menu and get the user's choice

    if choice == "1":  # Option to add an expense
        add_expense()
    elif choice == "2":  # Option to show the summary
        show_summary()
    elif choice == "3":  # Option to exit the program
        print("Thank you for using the Expense Tracker. Goodbye!")
        break  # Exit the loop
    else:
        print("Invalid choice. Please select a valid option.")  # Handle invalid menu choices