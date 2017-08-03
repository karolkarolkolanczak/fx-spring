<%@include file="/WEB-INF/view/template/header.jsp"%>

    <div class="container">

        <nav class="navbar navbar-default ">
            <div style="margin: 20px">
                <h2>ADMINISTRATOR PANEL</h2>
            </div>
        </nav></br></br>
        <div class="row"></div>

        <div class ="col-md-offset-0 col-sm-5">

                <form:form action="admin" modelAttribute="user" method="post" class="form-horizontal" >
                <div class="form-group">
                    <label for="login" class="col-sm-2 control-label">Login</label>
                    <div class="col-sm-5">
                            <form:input path="login" id="login" class="form-control" value="${user.login}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="password" class="col-sm-2 control-label">Password</label>
                    <div class="col-sm-5">
                            <form:input path="password" id="password" class="form-control" value="${user.password}"/>
                    </div>
                </div></br>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-default">Sign in</button>
                    </div>
                </div>
            </form:form>

        </div>

    </div>
<%--Login: ${user.login} Pass: ${user.password}--%>
<%@include file="/WEB-INF/view/template/footer.jsp" %>
