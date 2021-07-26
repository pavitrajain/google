@module=search 
Feature: Search
	Description: This feature allows user to search anything
	
@id=1 @Regression @Somke
Scenario Outline: Search using keyword 
	Given User access google website
	When User search using keyword: <keyWord>
	Then User should see search results for <keyWord>
	
	@intreset=testAutomation
	Examples:
	| keyWord  |
	| selenium |
	
	@intreset=space
	Examples:
	| keyWord      |
	| solar system |

@id=2 @Regression
Scenario: Search without provide keyword
	Given User access google website
	When User search without providing keyword
	Then User should remain on google home page

@id=3 @pending
Scenario Outline: Search with special characters
	Given User access google website
	When User search using keyword: <keyword>
	Then User should see error message
	
	Examples:
	| keyword      |
	| !@#!@#!@#!@# |