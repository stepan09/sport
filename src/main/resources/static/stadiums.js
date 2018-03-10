/*
 * Copyright by Stepan Oliinyk (c) 2018.
 */

var app = angular.module("stadiums", []);

app.controller("AppCtrl", function ($scope, $http) {

    $scope.stadiums = [];
    $http.get('api/stadiums').then(function (response) {
        $scope.stadiums=response.data;
        console.log(response);
    });

    /*this.delStadium = function del(id) {
        $http.get('api/stadiums/del?id='+id).then(function (response) {
            window.alert('stadium ' + ' ' +response.data.name + ' ' +response.data.stadiumId + ' ' +response.data.address + ' ' + ' has been succesfully deleted!');
            window.location.reload();
        });
    };*/
});