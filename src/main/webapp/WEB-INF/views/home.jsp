<%@include file="../common/header.jsp.jspf"%>
<%@include file="../common/navbar.jsp.jspf"%>


<center><h1><p>LIST OF TODOS </p></h1><center>


<div class="container">
  
<table class="table">
  <thead>
  
    <tr>
      <th scope="col">Id</th>
      <th scope="col">User</th>
      <th scope="col">Description</th>
      <th scope="col">Target</th>
      <th scope="col">Is Done</th>
      <th scope="col"></th>
      <th scope="col"></th>
      
    </tr>
    
  </thead>
  <tbody>
<c:forEach items="${todos }" var="todo">
    <tr>
      <th scope="row">${todo.id }</th>
      <td>${todo.user }</td>
      <td>${todo.description}</td>
      <td>${todo.targetDate }</td>
      <td>${todo.done }</td>
      <td><a href="/delete-todo?id=${todo.id}"><button  class="btn btn-danger">delete</button></a></td>
      <td><a href="/update-todo?id=${todo.id}"><button  class="btn btn-primary">update</button></a></td>
   
      
       
     
    </tr>
 
    </c:forEach>
    
    
  </tbody>
</table>
</div>
<a href="/create-todo"><button type="button" class="btn btn-primary">AJOUTER</button></a>


<%@include file="../common/footer.jsp.jspf"%>