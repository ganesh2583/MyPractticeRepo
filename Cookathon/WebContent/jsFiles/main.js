function addReceipeViewModel(){
  console.log("Inside JS");
  var self = this;
  self.author = ko.observable(""),
  self.receipeTitle = ko.observable(""),
  self.receipeDescription = ko.observable(""),
  self.receipeIngredients = ko.observable(""),
  self.receipePreparation = ko.observable(""),
  addReceipe = function(){
    console.log("Thank you for your recipe!");
    console.log(" Input data is "+ko.toJSON(self));
    $.ajax(
    {
      type:'POST',
      url:'/Cookathon/webapi/v1/receipes',
      dataType: 'json',
      contentType: "application/json; charset=utf-8",
      data: ko.toJSON(self),
      success:function(data)
      {
        console.log("Input Data is "+data);
        $("#receipeSubmit").html(data);
    }

}); 
}
}

var addReceipeVM = new addReceipeViewModel();
ko.applyBindings(addReceipeVM);


        /*$('#receipeSubmit').html('sending..');

        $.ajax({
            url: '/webapi/v1/receipes',
            type: 'post',
            dataType: 'json',
            success: function (data) {
                $('#receipeSubmit').html(data.msg);
            },
            data: person
        });
    };*/