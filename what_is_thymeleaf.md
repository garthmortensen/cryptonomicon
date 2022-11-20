# What is Thymeleaf and what does it do?

https://stackoverflow.com/tags/thymeleaf/info
https://www.thymeleaf.org

It's a template engine. If you go to https://start.spring.io/ and click dependencies, you can see other template options including Apache Freemarker, Mustache, and Groovy. For Node.js, the leading template engine is Handlebars, I believe. What you insert into the HTML to capture variables might be called *hooks*.

Thymeleaf's a Java library for making MVC HTML views. It's a JSP alternative.

It typically serves as a webapp's HTML view layer. 

A *webapp* is an application running on a server.

It can be integrated with Spring, so it can be used as a JSP alternative.

It's an HTML template engine (extensible to other formats) that works for both web and standalone environments.

Thymeleaf's provides a good way to create templates, and use them as static prototypes.

Unlike JSP, Thymeleaf is a **natural** template engine, meaning that the file could be directly opened in browsers without having to run the application. I think that means it makes an html file. A natural template:

```html
<table>
  <thead>
    <tr>
      <th th:text="#{msgs.headers.name}">Name</th>
      <th th:text="#{msgs.headers.price}">Price</th>
    </tr>
  </thead>
  <tbody>
    <tr th:each="prod: ${allProducts}">
      <td th:text="${prod.name}">Oranges</td>
      <td th:text="${#numbers.formatDecimal(prod.price, 1, 2)}">0.99</td>
    </tr>
  </tbody>
</table>
```

- Simple expressions:
  - Variable Expressions: `${...}`
  - Selection Variable Expressions: `*{...}`
  - Message Expressions: `#{...}`
  - Link URL Expressions: `@{...}`
  - Fragment Expressions: `~{...}`

Thymeleaf can process 6 kinds of templates

1. html
2. xml
3. text
4. js
5. css
6. raw

Thymeleaf can be an html page containing thymeleaf expressions.

![java-thymeleaf](./images/java_to_tl.png)

Thymeleaf engine parses Thymeleaf templates.

The java model's data is read into the view (thyemleaf template). Thymeleaf engine then produces static html page.

![mvc](./images/mvc.png)

If webapp, thymeleaf is processed on the server. Rendered html is sent back to client browser.

## Create basic thymeleaf webapp

When you first create a Thymeleaf project using Spring Initializer site, include two dependencies. These are visible in the resultant `pom.xml`, Project Object Model. This sounds like DOM, Document Object Model used in html. Both are Object Models, which when googled renders this site: https://www.techopedia.com/definition/8635/object-model#:~:text=An%20object%20model%20is%20a,oriented%20programming%20(OOP)%20lifecycle.

> An object model is a logical interface, software or system that is **modeled through the use of object-oriented techniques**. It enables the creation of an architectural software or system model prior to development or programming.
>
> An object model is part of the object-oriented programming (OOP). An object model helps describe or define a software/system in terms of objects and classes. It defines the interfaces or interactions between different models, inheritance, encapsulation and other object-oriented interfaces and features.

![pom](./images/pom_dep.png)

Create a Spring MVC controller, via creating a new class in main.

@Controller is used to mark a class as a web request handler.

```java
package net.javaguides.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloWorldController {

	// create a method handler which returns "hello world"
	@GetMapping("/hello")  // reference url /hello
	public String hello(Model model) {  // this will return some data, so use a Model
		model.addAttribute("message", "Hello world");  // key value. copy "message" into html template
		return "helloworld";  // returns a thymeleaf template `helloworld.html`
	}	
}
```

Create an HTML thymeleaf template.

Thymeleaf dir structure has `static` for js, css, and `templates` for html.

```html
<!DOCTYPE html>
<!-- add this to reference thymeleaf functionality -->
<html xmlns:th="https//thymeleaf.org"> 
<head>
<meta charset="ISO-8859-1">
<title>Thymeleaf helloworld app</title>
</head>
<body>
	<!-- thymeleaf variable expression -->
	<h1 th:text = "'Thymeleaf ' + ${message} + ' App'"></h1>
</body>
</html>
```

Run it by browsing to `http://localhost:8080/hello`

## Add CSS and JS

Thymeleaf dir structure has `static` for js, css, and `templates` for html.

We now add files to `static`.

Could not parse as expression: "@{/js/actions.js" (template: "add-css-js-demo" - line 8, col 32)

For killing whatevers running on port 8080:

```cmd
C:\Users\me>netstat -ano | findstr :8080
  TCP    0.0.0.0:8080           0.0.0.0:0              LISTENING       2460
  TCP    [::]:8080              [::]:0                 LISTENING       2460
  TCP    [::1]:8080             [::1]:52170            TIME_WAIT       0

C:\Users\me>taskkill /PID 2460 /F
SUCCESS: The process with PID 2460 has been terminated.
```

## Add bootstrap css library to thymleap template

https://stackoverflow.com/tags/twitter-bootstrap/info
https://getbootstrap.com/
https://github.com/twbs/bootstrap

The most popular HTML, CSS, and JavaScript framework for developing responsive, mobile first projects on the web.

[Bootstrap](https://getbootstrap.com/) = a css framework for responsive, mobile-first frontend development. It includes html, css and (optionally) js templates for typography, forms, buttons, navigation, etc. On SO, it's tagged [twitter-bootstrap]. 2022/07, it's the eighth most starred project on GitHub.

If you only want Bootstrap's compiled css or js, you can use jsDelivr.

```html
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
```

or

```html
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
```

Add bootstrap to project.

Use CDN (content delivery network) https://getbootstrap.com/docs/3.3/getting-started/#download-cdn

## Thymeleaf for each loop

Look at code.

## Thymeleaf if, unless, switch

https://youtu.be/96ompySpPHE?t=2632

## Next

Update Redis project to have a Thymeleaf UI. Due to different dependencies, I think it would be easier to create a new project from scratch.



