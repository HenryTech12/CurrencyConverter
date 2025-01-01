<%@page import="java.util.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=Edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <title>HTML</title>
  
  <!-- HTML -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />

  <!-- Custom Styles -->
  <link rel="stylesheet" href="css/main.css">
</head>

<body>
   <% List<String> list = (List) request.getAttribute("list"); %>
  <!-- Project -->
  <main class="container">
    <form action="convert">
      <header class="header">
        <h2>Currency Converter</h2>
      </header>
      <div class="form-content">
        <label class="amount">Enter Amount</label>
        <input type="text" placeholder="0" name="amount">
        <div class="convert">
          <section class="s">
            <label class="l">From</label>
            <select name="from">
              <optgroup>
               <% if(list != null) { %>
                <% for(int i = 0; i < list.size()-1; i++) { %>
                      <option><%= list.get(i) %> </option>
                <% } %>
                <% } %>
              </optgroup>
            </select>
          </section>
          
         <span class="material-symbols-outlined">
            sync_alt </span>
          
          <section class="s">
            <label class="l">To</label>
            <select name="to">
              <optgroup>
                <% if(list != null) { %>
                <% for(int i = list.size()-1; i > 0; i--) { %>
                      <option><%= list.get(i) %> </option>
                <% } %>
                <% } %>
              </optgroup>
            </select>
          </section>
        </div>
        
        <span class="display">${result}</span>
        <input type="submit" value="get exchange rate">
      </div>
    </form>
  </main>
  <script src="main.js"></script>
</body>
</html