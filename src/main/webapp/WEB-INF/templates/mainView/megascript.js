$(document).ready(function() {

    var listLocations = $('#list-group')[0];
    var searchButton = document.getElementById("search");
    var table = $('.table-here');
    //
    // searchButton.addEventListener("click", list);

    $('#search').click(function () {
      list();
    })

});

function list() {
  var searchInput = document.getElementById("inslineFormInputName2");
  console.log(searchInput.value);
  console.log('clicked');

$.ajax({
  url: 'https://mega-ac.herokuapp.com/api/location/name/' + searchInput.value,
  type: 'GET',
  async: true,
  success: function (response) {
    successCallbackget(response)
  },
  error: errorCallback
});
}

function successCallbackget(response) {
  $("#bodybody tr").remove();

  var table2 = document.getElementById('bodybody');

  response.forEach((item) => {

    var row = table2.insertRow();

    row.insertCell(0).innerHTML = '<tr><a href="https://mega-ac.herokuapp.com/' + item.id + '" class="list-group-item list-group-item-action">' + item.name + '</a></tr>';
});
}

function errorCallback(request, status, error) {
    console.log('Sorry, something went wrong on the list...');
}
