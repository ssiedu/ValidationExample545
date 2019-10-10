<html>
    <body>
        <h3>Data-Entry-Form</h3>
        <form action="DataProcessing">
            <pre>
            Name    <input type="text" id="t1" name="t1"/> <%=request.getAttribute("nameErr")%>
            Age     <input type="text" id="t2" name="t2"/> <%=request.getAttribute("ageErr")%>
                    <input type="submit" value="Submit"/>
            </pre>
        </form>
    </body>
</html>
