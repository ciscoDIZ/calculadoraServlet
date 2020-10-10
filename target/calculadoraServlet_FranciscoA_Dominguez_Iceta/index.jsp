<html>
<body>
<h2>Calculadora</h2>
<form action="operadora" method="post">
    <table>
        <tr>
            <td><input type="text" placeholder="operando" name="opa" size="2"></td>
            <td>
                <select name="opr" id="opr">
                    <option value="+">+</option>
                    <option value="-">-</option>
                    <option value="*">*</option>
                    <option value="/">/</option>
                </select>
            </td>
            <td><input type="text" placeholder="operando" name="opb" size="2"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Enviar"></td>
            <td><a href="gestor?his=1">ver historial...</a></td>
        </tr>
    </table>
    <%
        if(request.getAttribute("res") != null){
            String res = (String)request.getAttribute("res");
            out.print(res);
        }
    %>
</form>
</body>
</html>
