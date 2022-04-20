Feature: As a data consumer, I want the user information are stored in mySql DB correctly in users table

	Background:
		#@CY10-148
		Given Establish the database connection
		

	
	@CY10-149
	Scenario: Verify all users has unique ID
		When Execute query to get all IDs from users
		Then verify all users has unique ID

	@CY10-150
	Scenario: Verify the below columns are listed in result
		When Execute query to get all columns
		Then verify the below columns are listed in result

			| id            |
			| full_name     |
			| email         |
			| password      |
			| user_group_id |
			| image         |
			| extra_data    |
			| status        |
			| is_admin      |
			| start_date    |
			| end_date      |
			| address       |