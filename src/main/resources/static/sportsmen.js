var app = angular.module("sportsmen", []);

app.controller("AppCtrl", function ($scope, $http) {

    $scope.sportsmen = [];
    $http.get('api/sportsmen').then(function (response) {
        $scope.sportsmen=response.data;
        console.log(response);
    });

    this.delSportsman = function del(id) {
        $http.get('api/sportsmen/{id}='+id).then(function (response) {
            window.alert('Sportsman ' + ' ' +response.data.lastName + ' ' +response.data.sportsmanId + ' ' +response.data.firstName + ' ' + ' has been succesfully deleted!');
            window.location.reload();
        });
    };
});