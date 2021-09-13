
<%@include file="../common/header.jsp.jspf"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 

<%@include file="../common/navbar.jsp.jspf"%>

<style>
    body {
            color: #566787;
            background: #f5f5f5;
            font-family: 'Varela Round', sans-serif;
            font-size: 13px;
        }
</style>

<section>
	<div class="container">
		<div align="center" class="mt-4 mb-4">
		         
				 
		</div>
		<div class="col-md-8 m-auto">
		   <div class="card">
			   <div class="card-body">
			        <form:form class="row g-3" method="post" action="/update-todo?id=${todo.id }" modelAttribute="todo">
			            
					    <div class="col-md-6 mt-2">
							<form:label path="description" class="form-label">Description</form:label>
							<form:input path="description" class="form-control" />
					    </div>
 
			            <div class="col-12 mt-3">
			               <button onclick="return confirm('Are you sure!')" type="submit" class="btn btn-success">Save Change</button>
			            </div>
			        </form:form>
			   </div>
		   </div>
		   
		</div>
	</div>
</section>

<%@ include file="../common/footer.jsp.jspf" %>
 
</div>

<%@include file="../common/footer.jsp.jspf"%>

