<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<title>Register Student</title>
</head>

<body>

	<div class="container">

		<h3>Student Registration System</h3>
		<hr>

		<p class="h4 mb-4">Register Student</p>

		<form action="/StudentRegistrationManagement/student/save"
			method="POST">

			<!-- Add hidden form field to handle update -->
			<input type="hidden" name="studentId" value="${Student.studentId}" />

			<div class="form-group row">
				<label for="name" class="col-sm-2 col-form-label">Student
					Name</label>
				<div class="col-sm-7">
					<input type="text" name="name" value="${Student.name}"
						class="form-control mb-4 col-4" placeholder="Name">

				</div>

			</div>

			<div class="form-group row">
				<label for="department" class="col-sm-2 col-form-label">Student
					Department</label>
				<div class="col-sm-7">

					<input type="text" name="department" value="${Student.department}"
						class="form-control mb-4 col-4" placeholder="Department">

				</div>

			</div>

			<div class="form-group row">
				<label for="country" class="col-sm-2 col-form-label">Student
					Country</label>
				<div class="col-sm-7">

					<input type="text" name="country" value="${Student.country}"
						class="form-control mb-4 col-4" placeholder="Country">

				</div>

			</div>

			<button type="submit" class="btn btn-info col-2">Save</button>

		</form>

		<hr>
		<a href="/StudentRegistrationManagement/student/list">Back to
			Students List</a>

	</div>
</body>

</html>










