<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<head>
  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style1.css">
  <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/calendrier.js"></script>
</head>
<div class="errors">
  ${exception }
</div>



<div id="formUser" class="cadre">

<!-- Tableau obligatoire ! C'est lui qui contiendra le calendrier ! -->
<table class="ds_box" id="ds_conclass" style="display: none;">
			<tr>
				<td id="ds_calclass"></td>
			</tr>
</table>
 <f:form modelAttribute="user" action="saveUser" method="post" enctype="multipart/form-data">
   <table>
     <tr>
       <td>ID </td>
       <td><f:input path="ID"/></td>
       <td><f:errors path="ID" cssClass="errors"></f:errors></td>
     </tr>
     <tr>
     <td>Login</td>
       <td><f:input path="Login"/></td>
       <td><f:errors path="Login" cssClass="errors"></f:errors></td>
     </tr>
     <td>password</td>
       <td><f:input path="password"/></td>
       <td><f:errors path="password" cssClass="errors"></f:errors></td>
     </tr>
      <tr>
     <td>Nom</td>
       <td><f:input path="nom"/></td>
       <td><f:errors path="nom" cssClass="errors"></f:errors></td>
     </tr>
     <tr>
      <tr>
     <td>Prenom</td>
       <td><f:input path="prenom"/></td>
       <td><f:errors path="prenom" cssClass="errors"></f:errors></td>
     </tr>
     <tr>
     <td>Email</td>
       <td><f:input path="email"/></td>
       <td><f:errors path="email" cssClass="errors"></f:errors></td>
     </tr>
     <tr>
     <td>Adresse</td>
       <td><f:textarea path="adresse"/></td>
       <td><f:errors path="adresse" cssClass="errors"></f:errors></td>
     </tr>  
     <tr>
      <td>Photo</td>
       <td>
       <c:if test="${user.ID!=null}">
         <img alt="" src="photoUser?userID=${user.ID}">
       </c:if>
       </td>
       <td>
       
       <input type="file" name="file"/>
       </td>  
     </tr>
     <tr> 
     <td>Date naissance</td>
       <td><f:input path="dateNaissance" type="date"  onclick="ds_sh(this);"/></td>
       <td><f:errors path="dateNaissance" cssClass="errors"></f:errors></td>
     </tr>
       <tr>
     <td>Activé</td>
       <td><f:checkbox path="active" value="1"/></td>
       <td><f:errors path="active" cssClass="errors"></f:errors></td>
     </tr>   
      <tr>
       <td><input type="submit" value="Save"/></td>
      </tr>
   </table>
 </f:form>
</div>
<div id="tabUsers" class="cadre">
	<table class="tab1">
		<tr>
		  <th>ID</th><th>LOGIN</th><th>NOM</th><th>PRENOM</th><th>EMAIL</th>
		  <th>ADRESSE</th><th>DATE NAISSANCE</th><th>PHOTO</th><th>ACTIVE</th>
		</tr>
	<c:forEach items="${users}" var="p">
	    <tr>
	       <td>${p.ID}</td>
	       <td>${p.login}</td>
	       <td>${p.nom}</td>
	       <td>${p.prenom}</td>
	       <td>${p.email}</td>
	       <td>${p.adresse}</td>
	       <td>${p.dateNaissance}</td>
	       <td><img alt=""src="photoUser?userID=${p.ID}"></td>
	       <td>${p.active}</td>
	       <td><a href="suppUser?userID=${p.ID}">Supprimer</a></td>
	       <td><a href="editUser?userID=${p.ID}">Editer</a></td>
	         
	    </tr>
	</c:forEach>
	</table>
</div>