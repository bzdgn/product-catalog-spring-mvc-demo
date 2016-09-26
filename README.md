# 01 Screenshots;

## 01-A) Product List Page

![alt text](http://leventdivilioglu.com/prod-cata-ss/01_products-list-page.png "Product List Page")

## 01-B) Product Details Page

![alt text](http://leventdivilioglu.com/prod-cata-ss/02_product-detail-page.png "Product Detail Page")

## 01-C) Product Details Page Confirmation Modal

![alt text](http://leventdivilioglu.com/prod-cata-ss/03_product-detail-page-confirmation.png "Product Detail Page Confirmation")

## 01-D) Shopping Cart Page

![alt text](http://leventdivilioglu.com/prod-cata-ss/04_shopping-cart-page.png "Shopping Cart Page")

## 01-E) Search Functionality

![alt text](http://leventdivilioglu.com/prod-cata-ss/05_search-functionality.png "Search Screenshot")

## 01-F) List Products By Selected Category

![alt text](http://leventdivilioglu.com/prod-cata-ss/06-list-by-category.png "Category Listing Screenshot")

# 02 Project Setup

	Following maven archetype is used to create web application

`	mvn archetype:generate
		-DgroupId=com.levent.pcd
		-DartifactId=ProductCatalogDemo
		-DarchetypeArtifactId=maven-archetype-webapp
		-DinteractiveMode=false
		
	mvn archetype:generate -DgroupId=com.levent.pcd -DartifactId=ProductCatalogDemo -DarchetypeArtifactId=maven-archetype-webapp -DinteractiveMode=false`

## 03 Project Setup

- MongoDB is needed for this project
- On windows, simply run the command below (notify that you have to specify a dbpath parameter)

`mongod --port 27017 --dbpath D:\MONGOTEST\data`

I'm using the command below on my windows machine;

`C:\Program Files\MongoDB\Server\3.0\bin>mongod --port 27017 --dbpath D:\MONGOTEST\data`

## 04 Project Data

- Database name is specified on `servlet-config.xml` (WEB-INF/config/servlet-config.xml), 
and set to `levent`. You can change or set an arbitrary name for it.

- Use the database name specified on `servlet-config.xml`

`use levent`

- Create a collection named `products` with the following command, you can run it on mongo client;

`db.createCollection('products')`

- Populate the collection with the following command, just copy and paste it on mongo client.
Also notify that database data is located on `src/resources/database-data` folder;

`db.runCommand({
	insert: 'products',
	documents: [
		{
			_id: '1',
			productCode: 'AX329T',
			categories: ['men'],
			productName: 'Light Brown Men Shoe 1',
			imageUrl: '01_men_one.jpg',
			price: 68.39,
			size: 43,
			color: 'lightbrown'
		},
		{
			_id: '2',
			productCode: '6X3D93',
			categories: ['men'],
			productName: 'Brown Men Shoe 2',
			imageUrl: '02_men_two.jpg',
			price: 81.99,
			size: 41,
			color: 'brown'
		},
		{
			_id: '3',
			productCode: 'NX3G66',
			categories: ['men'],
			productName: 'Dark Brown Men Shoe 3',
			imageUrl: '03_men_three.jpg',
			price: 70.26,
			size: 42,
			color: 'darkbrown'
		},
		{
			_id: '4',
			productCode: '37Y29D',
			categories: ['women'],
			productName: 'Black High Heel Women Shoe',
			imageUrl: '04_women_one.jpg',
			price: 99.84,
			size: 36,
			color: 'black'
		},
		{
			_id: '5',
			productCode: '223JDH',
			categories: ['women'],
			productName: 'Black Women Shoe 2', 
			imageUrl: '05_women_two.jpg',
			price: 102.67,
			size: 37,
			color: 'black'
		},
		{
			_id: '6',
			productCode: '7DGFF1',
			categories: ['men', 'children', 'boy'],
			productName: 'Black Blue Boy Shoe 1',
			imageUrl: '06_men_children_01.jpg',
			price: 51.14,
			size: 3,
			color: 'blue'
		},
		{
			_id: '7',
			productCode: 'DJ7CY3',
			categories: ['men',	'children', 'boy'],
			productName: 'White Cream Boy Sport Shoe 2',
			imageUrl: '07_men_children_02.jpg',
			price: 43.36,
			size: 4,
			color: 'cream'
		},
		{
			_id: '8',
			productCode: '3HDAA7',
			categories: ['girl', 'children', 'women'],
			productName: 'Girl Pinky White Shoe 1',
			imageUrl: '08_girl_children_01.jpg',
			price: 45.44,
			size: 2,
			color: 'white'
		},
		{
			_id: '9',
			productCode: 'JFJE7X',
			categories: ['girl', 'children'],
			productName: 'Girl Pinky Black Shoe 2',
			imageUrl: '09_girl_children_02.jpg',
			price: 55.24,
			size: 3,
			color: 'pink'
		}
	]
})`