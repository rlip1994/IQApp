'use strict';

/**
 * @ngdoc function
 * @name iqwebApp.controller:ProfileCtrl
 * @description
 * # ProfileCtrl
 * Controller of the iqwebApp
 */
angular.module('iqwebApp').controller('resultsCtrl', function ($scope,$http,$filter) 
{
  //{age : ageFilter,school : schoolFilter,level: levelFilter, name : nameInput}
    $scope.nameKid = "";
    $scope.filterResult = [];
    $scope.results = [];
    

    //DropDown SCHOOLS
    $http.get('http://andresolis-littlestark.c9users.io:8080/getSchool/names')
    .then(function(response){
        $scope.schools=response.data[0];
        $scope.schools.push({name:"Ninguno"});
        $scope.schoolSelected = "Ninguno";
        $scope.schoolFilter ="";
        
    }).catch(function(error){
      alert('Error en servidor');
    });
    //DropDown AGE 
    $scope.years = [{num:"8"},{num:"9"},{num:"10"},{num:"11"},{num:"12"},{num:"13"},{num:"Ninguno"}];
    $scope.ageSelected = "Ninguno";
    $scope.ageFilter = "";
    //DropDown CATERGORIES
    $http.get('http://andresolis-littlestark.c9users.io:8080/categories').then(function(response){
        $scope.categories=response.data[0];
        $scope.categories.push({name: "Ninguno"});
        $scope.categorySelected = "Ninguno";   
        $scope.categoryFilter = "";
    }).catch(function(error){
      alert('Error en servidor');
    });
    //$scope.filterResult = $scope.results;
    
    
  $scope.getKidGames = function(idKid){
    return $http.get('http://andresolis-littlestark.c9users.io:8080/results/kidGames/'+idKid)
    .then(function(response)
    {
      return response.data[0];
    })
    .catch(function(error)
    {
        alert(error.message);
    });
          

  };
  $http.get('http://andresolis-littlestark.c9users.io:8080/results/')
    .then(function(kids)
    {
        kids.data[0].forEach(function(kid)
        {
          $http.get('http://andresolis-littlestark.c9users.io:8080/results/kidGames/'+kid.idPlayer)
          .then(function(games)
          {
            console.log(games);
            kid.games=games.data[0];
            kid.category = "";
            var grade  = 0;

            kid.games.forEach(function(game){
              grade += game.grade;
            });
            kid.grade = grade/kid.games.length;
            kid.mainGrade = kid.grade;
            $scope.filterResult.push(kid);
            $scope.results.push(kid);
          })
          .catch(function(error)
          {
            console.log(error);
          });

        });
    }).catch(function(error){
      console.log(error);
  });

   //Main results controllers
  $scope.updateMainResults = function(){
     var averageCounter = 0;
     var speedCounter = 0;
    //Update main average 
     $scope.filterResult.forEach(function(element){
        averageCounter += parseInt(element.grade);
     });
     $scope.average = parseInt((averageCounter/parseInt($scope.filterResult.length)));
     $scope.kidCount = $scope.filterResult.length;
  };

  $scope.filterResults= function(){ 
      $scope.filterResult = $filter('filter')($scope.results,{"age": $scope.ageFilter,"school" :$scope.schoolFilter, "name" : $scope.nameKid ,"category" : $scope.categoryFilter});
      $scope.updateMainResults();    
  };
  $scope.filterResults();

  //Controllers functions
  $scope.updateSchoolDropDown = function (school) {
    $scope.schoolSelected = school;
      if($scope.schoolSelected ==="Ninguno"){ 
        $scope.schoolFilter = ""
      }else{
        $scope.schoolFilter = $scope.schoolSelected;
      };
    $scope.filterResults();
  };
   $scope.updateAgeDropDown = function (age) {
      $scope.ageSelected = age;
      if($scope.ageSelected ==="Ninguno"){ 
        $scope.ageFilter = ""
      }else{
        $scope.ageFilter = $scope.ageSelected;
      };
      $scope.filterResults();
  };
  $scope.updateCatergoryDropDown = function (category) {
      $scope.categorySelected = category;
      if($scope.categorySelected === "Ninguno"){ 
        $scope.categoryFilter = ""
        $scope.filterResult.forEach(function(kid){
          kid.grade = kid.mainGrade;
          kid.category = "";

        });
      }else{
        $scope.categoryFilter = ""
        $scope.filterResult.forEach(function(kid){
          kid.grade = kid.mainGrade;
          kid.category = "";

        });
        
        $scope.categoryFilter = $scope.categorySelected;
        $scope.filterResult.forEach(function(kid)
        {
          var game = kid.games.find(x => x.category === $scope.categoryFilter);
          if(game ===undefined){
            kid.category = "";
          }else{
            console.log(game.grade);
            kid.grade = game.grade;
            kid.category = game.category
          }
          
        });
      };
      $scope.filterResults();
      
  };





 
  $scope.showCategoryFilter = function(){
    
  };



  $scope.printGames = function() 
  {
    alert(JSON.stringify($scope.filterResult[0].games));
  };

  
});

