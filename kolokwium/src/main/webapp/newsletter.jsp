<jsp:useBean id="settingsService" class="app.service.SettingsService" scope="application" />
<html><body>
<form action="saved.jsp" method="post">
Date from:<br>
<input type="date" name="dateFrom"><br>
Date to:<br>
<input type="date" name="dateTo">
<p>Every Day<input type="radio" id="day" name="freq" value="day"
></p>
<p>Every Month<input type="radio" id="month" name="freq" value="month"
></p>
<p>Every Year<input type="radio" id="year" name="freq" value="year"
></p>
Parrots from:
Australia: <input type="checkbox" id="aus" name="aus">
Europe: <input type="checkbox" id="eur" name="eur">
India: <input type="checkbox" id="ind" name="ind">
<input type="submit" value="Ustaw">
</form>
</body></html>