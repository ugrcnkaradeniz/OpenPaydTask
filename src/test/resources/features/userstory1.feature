@user_story1
Feature:Open Payd Task

  @testcase1
  Scenario Outline:Counting posts for user
    When I get list of blog posts
    Then user <user> should have <numposts> posts
    Examples:
    |user|numposts|
    |5   |10      |
    |7   |10      |
    |9   |10      |

  @testcase2
  Scenario: Unique ID per post
    When I get list of blog posts
    Then verify each blog posts have unique ID

  @testcase3 @UI
   Scenario Outline:Acceptance criteria implementation
     Given the user go to url
     And user send "<product>" keyword to search input
     And verify "<product>" found
     And add non-discounted products on the first page
     Then go to cart
     Then verify product on the cart
     Examples:
     |product|
     |laptop |

