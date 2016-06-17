/**
 * Created by chevvson on 17.06.16.
 */
(function () {
    'use strict';

    angular
        .module('maxwellApp')
        .controller('calculatorController', calculatorController);


    function calculatorController($scope) {
        $scope.chosen = 1;

        $scope.choseCalc = function(chosen){
            $scope.chosen = chosen;
        };

        $scope.isChosen = function(chosen){
            return (chosen === $scope.chosen);
        };

        $scope.checkBMI = function(value){
            if(value <= 18.5){
                $scope.comment = "Underweight";
            }
            else if(value <= 25){
                $scope.comment = "Normal healthy weight";
            }
            else if(value <= 27){
                $scope.comment = "Overweight at risk";
            }
            else if(value <= 30){
                $scope.comment = "Overweight - moderately obese";
            }
            else if(value > 30){
                $scope.comment = "Overweight - severely obese";
            }
        };

        $scope.checkWHR = function(value ,sex ){
            if(sex ==='m'){
                if(value <= 0.9){
                    $scope.comment = "Normal weight";
                }else if (value <= 0.99){
                    $scope.comment = "Over-weight";
                }else if(value >1.00){
                    $scppe.comment = "Obesity";
                }
            }else if(sex ==='w'){
                if(value <= 0.8){
                    $scope.comment = "Normal weight";
                }else if (value <= 0.84){
                    $scope.comment = "Over-weight";
                }else if(value >0.85){
                    $scope.comment = "Obesity";
                }
            }
        };

        $scope.calcBMI = function(height, weight){
            height = parseFloat(height/100);
            $scope.bmi = parseFloat(weight/(height*height));
            $scope.checkBMI($scope.bmi);
        };

        $scope.calcWater = function(wweight) {
            if (wweight <= 10) {
                $scope.water = wweight * 100;
            }else if(wweight <= 20){
                $scope.water = 10*100 + (wweight-10)*50;
            }else{
                $scope.water = 10*100 + 10*50 + (wweight-20)*20;
            }
        };

        $scope.calcWHR = function(waist, hip, sex) {
            $scope.whr = waist/hip;
            $scope.checkWHR($scope.whr, sex);
        };

        $scope.calcIdeal = function(iheight, sex){
            if(sex === "m"){
                $scope.idealW = iheight - 100 - ((iheight - 150)/4);
            }else if( sex === "w"){
                $scope.idealW = iheight - 100 - ((iheight - 150)/2);
            }
        };

        $scope.calcDailyCalor = function(){

        };

        $scope.calcRecomProt = function(activity, pweight){
            if(activity ==='1'){
                $scope.proteins = pweight*0.8;
            }else if(activity === '2'){
                $scope.proteins = pweight;
            }else if(activity === '3'){
                $scope.proteins = pweight*1.5;
            }
        };
    }
})();
