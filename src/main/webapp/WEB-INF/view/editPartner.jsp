<%@include file="/WEB-INF/view/template/header.jsp"%>

    <div class="container">

    <nav class="navbar navbar-default ">
        <div style="position:absolute; top:5px; right:10px" >
            <%--Welcome Admin: '<b><%=user.getLogin()%></b>'</br>--%>
        </div>
        <div style="position:absolute; top:30px; right:10px" >
            <form:form action="LogOut" method="get">
                <button type="submit" class="btn btn-default">log out</button>
            </form:form>
        </div>
        <div style="margin: 20px">
            <h2>ADMINISTRATOR PANEL</h2>
        </div>
    </nav>
    <div class="row"></div>

    <h4><b>Edit Partner:</b></h4> </br>
    <div class ="col-md-offset-0 col-sm-5">
        <form:form class="form-horizontal" action="editPartner" modelAttribute="partner" method="post">
            <div class="form-group">
                <div class="col-sm-5">
                    <%--<input type="hidden" class="form-control" id="partnerId" name="partnerId" value="<c:out value="${partnerDetails.partnerId}" />" >--%>
                    <form:input path="partnerId" id="partnerId" class="form-control" value="${partner.partnerId}" type="hidden"/>
                </div>
            </div>
            <div class="form-group">
                <label for="firstName" class="col-sm-3 control-label">First Name</label>
                <div class="col-sm-5">
                    <form:input path="firstName" id="firstName" class="form-control" value="${partner.firstName}"/>
                </div>
            </div>
            <div class="form-group">
                <label for="lastName" class="col-sm-3 control-label">Last Name</label>
                <div class="col-sm-5">
                    <form:input path="lastName" id="lastName" class="form-control" value="${partner.lastName}"/>
                </div>
            </div>
            <div class="form-group">
                <label for="login" class="col-sm-3 control-label">Login</label>
                <div class="col-sm-5">
                    <form:input path="login" id="login" class="form-control" value="${partner.login}"/>
                </div>
            </div>
            <div class="form-group">
                <label for="password" class="col-sm-3 control-label">Password</label>
                <div class="col-sm-5">
                    <form:input path="password" id="password" class="form-control" value="${partner.password}"/>
                </div>
            </div>
            <div class="form-group">
                <label for="email" class="col-sm-3 control-label">Email</label>
                <div class="col-sm-5">
                    <form:input path="email" id="email" class="form-control" value="${partner.email}"/>
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-offset-3 col-sm-8">
                    <button type="submit" class="btn btn-default">Save Partner</button>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-5">
                        <%--<input type="hidden" class="form-control" id="partnerId" name="partnerId" value="<c:out value="${partnerDetails.partnerId}" />" >--%>
                    <form:input path="closedTradesTransactionStrategyNumber" id="closedTradesTransactionStrategyNumber" class="form-control" value="${partner.closedTradesTransactionStrategyNumber}" type="hidden"/>
                </div>
            </div>

        </form:form>
    </div>

    <div class ="col-sm-6 ">
        <table class="table table-striped col-sm-6 ">
        <tr>
            <th>Partner Id</th>
            <th>First name</th>
            <th>Last name</th>
            <th>Login</th>
            <th>Password</th>
            <th>Email</th>
            <th>Transaction Strategy</th>

        </tr>
        <tr>
            <td><c:out value="${partner.partnerId}"/></td>
            <td><c:out value="${partner.firstName}"/></td>
            <td><c:out value="${partner.lastName}"/></td>
            <td><c:out value="${partner.login}"/></td>
            <td><c:out value="${partner.password}"/></td>
            <td><c:out value="${partner.email}"/></td>
            <td><c:out value="${partner.closedTradesTransactionStrategyNumber}" /></td>
        </tr>

        </table>
    </div>
    <div class="row"></div>

    <hr>
    <form:form action="GoToAdmin" method="get">
        <button type="submit" class="btn btn-default">back to main</button>
    </form:form>
</div>

<%@include file="/WEB-INF/view/template/footer.jsp" %>
