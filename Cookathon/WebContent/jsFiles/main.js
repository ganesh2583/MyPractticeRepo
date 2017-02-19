function addReceipeViewModel(){
  console.log("Inside JS 1");
  var self = this;
  self.author = ko.observable(""),
  self.receipeTitle = ko.observable(""),
  self.receipeDescription = ko.observable(""),
  self.receipeIngredients = ko.observable(""),
  self.receipePreparation = ko.observable(""),
  self.selectedingredients = ko.observableArray(""),
  self.ingredients = ko.observableArray(""),
  addIngredients = function(data, event){
    var allIngredients = self.receipeIngredients();
    var allIngredientsArray = allIngredients.split(",");
    for(var i=0;i<allIngredientsArray.length ; i++ ){
        if(self.ingredients.indexOf(allIngredientsArray[i]) < 0){
            console.log("Index of "+allIngredientsArray[i]+" "+self.ingredients.indexOf(allIngredientsArray[i]));
            self.ingredients.push(allIngredientsArray[i]);
        }
    }
    console.log("Array of values after update "+self.ingredients());
  };
  removeSelectedingredients = function () {
        self.ingredients.removeAll(self.selectedingredients());
        self.selectedingredients([]); // Clear selection
    };
  addReceipe = function(){
    var payload = self;
    console.log("Thank you for your recipe!");
    console.log("ingredients are "+JSON.stringify(self.ingredients()));
    var allIngredientsVar = "";
    var allIngredientsVarArray = self.ingredients();
    for (var i = allIngredientsVarArray.length - 1; i >= 0; i--) {
        allIngredientsVar = allIngredientsVar + allIngredientsVarArray[i] + ",";
    }
    payload.receipeIngredients = allIngredientsVar;
    delete payload.selectedingredients;
    delete payload.ingredients;
    console.log(" Input data is "+ko.toJSON(payload));
    $.ajax(
    {
      type:'POST',
      url:'/Cookathon/webapi/v1/receipes',
      dataType: 'json',
      contentType: "application/json; charset=utf-8",
      data: ko.toJSON(payload),
      success:function(data)
      {
        console.log("Input Data is "+data);
        $("#receipeSubmit").html(data);
      }

}); 
};

}

var addReceipeVM = new addReceipeViewModel();
ko.applyBindings(addReceipeVM);

$("showReceipes").ready(function(){
     console.log(" Inside ready call");
    $.ajax(
    {
      type:'GET',
      url:'/Cookathon/webapi/v1/receipes',
      dataType: 'json',
      contentType: "application/json; charset=utf-8",
      success:function(data)
      {
        var allReceipesIds = [];
        var allReceipesTitles = [];
        for (var i = data.length - 1; i >= 0; i--) {
            var title = data[i].receipeTitle;
            var id = data[i].receipeId;
            if(allReceipesIds.indexOf(id) < 0){
                allReceipesIds.push(id);
                allReceipesTitles.push(title);
            }
        }
        console.log("After populating the array "+JSON.stringify(allReceipesIds));
        console.log("After populating the array length is"+allReceipesIds.length);
        $("div#showReceipes").append('<ul>');
        for (var j = allReceipesIds.length - 1; j >= 0; j--) {
            var receipURL = '/Cookathon/webapi/v1/receipes/'+allReceipesIds[j];
            var ul = $("div#showReceipes > ul");
            ul.append('<li><a href="' + receipURL + '" class="getReceipeClass">' + allReceipesTitles[j] + '</a></li>');
        }
        $("div#showReceipes").append('</ul>');
    }
});
});

/*$("#getReceipeClass").on('click',function(){

    $ajax(
{
      type:'GET',
      url:$(this).val(),
      dataType: 'json',
      contentType: "application/json; charset=utf-8",
      success:function(data){
           console.log("Successfully access individual receipe") ;
      }
}
        );
});*/


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