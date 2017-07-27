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

    <h4><b>Partner details:</b></h4> </br>

    <div class ="col-lg-offset-0 col-lg-11 ">
        <table class="table table-striped">
            <tr>
                <th>Partner Id</th>
                <th>First name</th>
                <th>Last name</th>
                <th>Login</th>
                <th>Password</th>
                <th>Email</th>
                <th>Strategy</th>
                <th>Total Profit / Bonus (for period in USD)</th>
            </tr>
            <tr>
                <td><c:out value="${partner.partnerId}"/></td>
                <td><c:out value="${partner.firstName}"/></td>
                <td><c:out value="${partner.lastName}"/></td>
                <td><c:out value="${partner.login}"/></td>
                <td><c:out value="${partner.password}"/></td>
                <td><c:out value="${partner.email}"/></td>
                <td><c:out value="${partner.closedTradesTransactionStrategyNumber}" /></td>
                <td><b><span class="redColor">USD <c:out value="${totalBonusForPeriod}"/></span></b></td>
             </tr>

        </table>
    </div>
    <div class="row"></div>
<hr>
    <h4><b>Transactions list (closed trades):</b></h4>

    <div class ="col-lg-offset-0 col-lg-5">
        <form:form class="form-horizontal" modelAttribute="partnerDataUtil" action="detailsPartnerFilter" method="post">
            <div class="form-group">
                <div>
                    <%--<input  type="hidden" class="form-control" id="partnerId" name="partnerId" value="<c:out value="${partner.partnerId}"/>" >--%>
                    <form:input type="hidden" path="partnerId" id="partnerId" class="form-control" value="${partner.partnerId}"/>
                </div>
            </div>
            <div class="form-group">
                <label for="closedTradesFrom" class="col-sm-offset-0 col-sm-5 control-label">Trades from (Close Date)</label>
                <div class="col-sm-5">
                    <%--<input type="date" class="form-control" id="closedTradesFrom" name="closedTradesFrom" value="<c:out value="${closedTradesFrom}"/>" >--%>
                    <form:input type="date" path="closedTradesFrom" id="closedTradesFrom" class="form-control" value="${partnerDataUtil.closedTradesFrom}"/>
                </div>
            </div>
            <div class="form-group">
                <label for="closedTradesTo" class="col-sm-offset-0 col-sm-5 control-label">Trades To (Close Date)</label>
                <div class="col-sm-5">
                    <%--<input type="date" class="form-control" id="closedTradesTo" name="closedTradesTo" value="<c:out value="${closedTradesTo}"/>" >--%>
                    <form:input type="date" path="closedTradesTo" id="closedTradesTo" class="form-control" value="${partnerDataUtil.closedTradesTo}"/>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-5 col-sm-10">
                    <button type="submit" class="btn btn-default">Search</button>
                </div>
            </div>
        </form:form>
    </div> </br></br>

    <div class="row"></div>

    <div class ="col-lg-offset-0 col-lg-11 ">
        <table class="table table-striped">
            <tr>
                <th>Transaction Id</th>
                <th>Symbol</th>
                <th>Open Date</th>
                <th>Close Date</th>
                <th>Action</th>
                <th>Open Price</th>
                <th>Close Price</th>
                <th>Lots</th>
                <th>Profit</th>
            </tr>
        <c:forEach var="value" items="${closedTradesTransactionslist}">
            <tr>
                <td><c:out value="${value.transactionId}" /></td>
                <td><c:out value="${value.symbol}" /></td>
                <%--<fmt:formatDate type="date" value="${value.openDate}" pattern="yyyy-MM-dd" />--%>
                <td><c:out value="${value.openDate}" /></td>
                <td><c:out value="${value.closeDate}" /></td>
                <td><c:out value="${value.action}" /></td>
                <td><c:out value="${value.openPrice}" /></td>
                <td><c:out value="${value.closePrice}" /></td>
                <td><c:out value="${value.lots}" /></td>
                <td><c:out value="${value.profit}" /></td>
              <%--<td><a href="DeletePartnerServlet?parameterPartnerId=<c:out value='${value.partnerId}'/>"> delete </a></td>--%>
            </tr>
        </c:forEach>
        </table>
    </div>
    <div class="row"></div>
<h6>*source: <a href="https://www.instaforex.com" target="_blank">http://www.myfxbook.com</a></h6></br>

<h5>Total Bonus (USD <b>16</b> per Lot * <c:out value="${totalLotsTurnoverForPeriod}"/>) =  <b><span class="redColor">USD <c:out value="${totalBonusForPeriod}" /> </span></b></h5></br>
W przypadku pary walutowej EURUSD stawka bonusowa dla Partnera wynosi 16 USD za 1 Lota. Zatem za dany okres Partner otrzyma: USD 16 * <c:out value="${totalLotsTurnoverForPeriod}" /> Lota = <b><span class="redColor">USD <c:out value="${totalBonusForPeriod}"/></span></b>.

    <div class="row"></div>
    <hr>
    <form:form action="GoToAdmin" method="get">
        <button type="submit" class="btn btn-default">back to main</button>
    </form:form>
</div>

<%@include file="/WEB-INF/view/template/footer.jsp" %>