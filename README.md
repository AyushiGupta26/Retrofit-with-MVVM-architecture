# Retrofit-with-MVVM-architecture
It is an android application which uses Retrofit for fetching data from an API and displays it using the MVVM architecture.


<h2>Overview</h2>
This is an android app where users can post a requirement of mobile model they want to buy. For example, Mr Akash want to buy Nokia 6.1 Plus 6GB/64GB. He posts an order telling about the phone model, color, quantity and his expected price e.g Rs 15000. But he also says his expected price is negotiable. Now the interested sellers can bid on this requirement. Say Mr Varun can sell above model to
Mr Akash for Rs14700.The App has a screen where Mr Akash can look at the list of all the orders along with bids
users placed for ever order he posted.


The below API is used to fetch the data for the list, GET http://101.53.139.161:5000/bids/
(There is no authentication to the API)


Bidders details are displayed in ascending order according to the price.

Best Tag is shown in front of the Lowest Bid Amount in bidder’s details.
