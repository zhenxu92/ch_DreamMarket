# ch_DreamMarket

## Overview

This is a online market application with shopping cart feature mainly implemented. It also categorized commodities and 

- Customers can navigate through the page and add their idea commodities in the shopping cart

- Customers can also search the goods that they want, if there is any matching in product name, it will show up

- Customers can also seach the goods in terms of their categories

- Customers' ip is recorded so that whenever the same non-logged customer comes back, they are able to see their products in the shopping cart

## Tech Stacks

The main technology used here are not very new and fancy. The front MVC part is mostly implemented in Struts2. Bootstrap is added to brush up the layouts.

JQuery and some Javascript libraries are also used in here to better implement the features

The service layer has used [ModelDriven](https://struts.apache.org/core-developers/model-driven.html) as Struts2 interceptor to perform the object binding the action classes.

MySql database is used to store the users data, including their shopping cart data, account info and some behaviours.

## To use

1. Clone this repo or download it in your local repo.

2. Open this project in any IDE, MyEclipse recommended.

3. Run this application with Tomcat Servers.
