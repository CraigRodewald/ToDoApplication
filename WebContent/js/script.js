
$.ajax(
  type: 'Post',
  url:"http://localhost.8080/ToDoList/ToDoListServlet",
  success function (data) {
    document.write(data)

    var ToDoList = JSON.parse(data);
    var item = ToDoList.item_name;
    document.getElementById("btn").addEventListener("click"),

    function(){
      document.getElementById("demo").innerHTML=item
    }
  }
);
