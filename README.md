# H1 01 Screenshots;

## H2 01-A) Product List Page

![alt text](http://leventdivilioglu.com/prod-cata-ss/01_products-list-page.png "Product List Page")

## H2 01-B) Product Details Page

![alt text](http://leventdivilioglu.com/prod-cata-ss/02_product-detail-page.png "Product Detail Page")

## H2 01-C) Product Details Page Confirmation Modal

![alt text](http://leventdivilioglu.com/prod-cata-ss/03_product-detail-page-confirmation.png "Product Detail Page Confirmation")

## H2 01-D) Shopping Cart Page

![alt text](http://leventdivilioglu.com/prod-cata-ss/04_shopping-cart-page.png "Shopping Cart Page")

## H2 01-E) Search Functionality

![alt text](http://leventdivilioglu.com/prod-cata-ss/05_search-functionality.png "Search Screenshot")

## H2 01-F) List Products By Selected Category

![alt text](http://leventdivilioglu.com/prod-cata-ss/06-list-by-category.png "Category Listing Screenshot")


00 Project Startup
******************
	Following maven archetype is used to create web application

	mvn archetype:generate
		-DgroupId=com.levent.pcd
		-DartifactId=ProductCatalogDemo
		-DarchetypeArtifactId=maven-archetype-webapp
		-DinteractiveMode=false
		
	mvn archetype:generate -DgroupId=com.levent.pcd -DartifactId=ProductCatalogDemo -DarchetypeArtifactId=maven-archetype-webapp -DinteractiveMode=false

01 Java Version Setup on POM
****************************

	Use maven-compiler-plugin, 
	refer to : 	https://maven.apache.org/plugins/maven-compiler-plugin/examples/set-compiler-source-and-target.html
	
	Added the following maven plugin under build tag;
	
			<plugins>
				<plugin>
					<groupId>org.apache.maven.plugins</groupId>
					<artifactId>maven-compiler-plugin</artifactId>
					<version>3.5.1</version>
					<configuration>
						<source>1.8</source>
						<target>1.8</target>
					</configuration>
				</plugin>
			</plugins>

02 WEB.xml Servlet Descriptor
*****************************
	Update Servlet Descriptor version
	refer to: http://www.mkyong.com/web-development/the-web-xml-deployment-descriptor-examples/
	
	It's better to add the xml tag, it's missing on the default maven output file;
	<?xml version="1.0" encoding="UTF-8"?>
	
03 Servlet API scope must be set to 'provided'
**********************************************
	It is good that you use the scope of the servlet api as 'provided'
	Servlet Container (tomcat) has the api, no need to use the default mode;
	
		<!-- https://mvnrepository.com/artifact/javax.servlet/servlet-api -->
		<dependency>
		    <groupId>javax.servlet</groupId>
		    <artifactId>servlet-api</artifactId>
		    <version>2.5</version>
		    <scope>provided</scope>
		</dependency>
		
04 Configuration Path
*********************
	/WEB-INF/config/servlet-config.xml
	
05 Flow
*******
	a- web.xml
		- Servlet Mapping guides matched url pattern to a specific servlet
		- Specific dispatcher servlet init-params leads to servlet configuration
		
	b- servlet-config.xml
		- defines the controller base package thus guides to the controller classes
		- controller class method with the appropriote request mapping will handle the request
		- controller class with the matched request mapping, 
			returns to the target jsp page to be rendered (view)
	
	c- servlet-config.xml
		- the view page is going to be found on the location where InternalResourceViewResolver
			bean configured to, which is '/WEB-INF/jsp/' with the suffix ".jsp" 
		- page is rendered (org.apache.jasper) with the model mapping attributes populated in controller
		
06 Data
*******
mongod --port 27017 --dbpath D:\MONGOTEST\data

C:\Program Files\MongoDB\Server\3.0\bin>mongod --port 27017 --dbpath D:\MONGOTEST\data

db.createCollection('products')
db.createCollection('categories')

db.products.find({ categories: { '$in':['children'] } })

db.runCommand( { insert: 'products', documents:[] } )
db.runCommand( { insert: 'categories', documents:[] } )

Categories;

[
{
	_id: '1',
	categoryName: 'men',
	products: []
},
{
	_id: '2',
	categoryName: 'women',
	products: []
},
{
	_id: '3',
	categoryName: 'children',
	products: []
}
]

Products;

