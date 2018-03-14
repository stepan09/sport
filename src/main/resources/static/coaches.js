/*
 * Copyright by Stepan Oliinyk (c) 2018.
 */

var app = angular.module("coaches", []);

app.controller("AppCtrl", function ($scope, $http) {

    $scope.coaches = [];
    $http.get('api/coaches').then(function (response) {
        $scope.coaches=response.data;
        console.log(response);
    });

    this.delCoach = function del(id) {
        $http.delete('api/coaches/del/'+id).then(function (response) {
            window.alert('coach ' + ' ' +response.data.lastName + ' ' +response.data.coachId + ' ' +response.data.firstName + ' ' + ' has been successfully deleted!');
            window.location.reload();
        });
    };

    this.readCoach = function read(id) {
        $http.get('api/coaches/'+id).then(function (response) {
            window.alert('Coach ' + ' ' + response.data.lastName + ' ' + response.data.firstName
            + ' ' + response.data.middleName);
        })
    }
});