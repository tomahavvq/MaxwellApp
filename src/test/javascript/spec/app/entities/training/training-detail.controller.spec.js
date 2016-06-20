'use strict';

describe('Controller Tests', function() {

    describe('Training Management Detail Controller', function() {
        var $scope, $rootScope;
        var MockEntity, MockTraining, MockExerciseDetails;
        var createController;

        beforeEach(inject(function($injector) {
            $rootScope = $injector.get('$rootScope');
            $scope = $rootScope.$new();
            MockEntity = jasmine.createSpy('MockEntity');
            MockTraining = jasmine.createSpy('MockTraining');
            MockExerciseDetails = jasmine.createSpy('MockExerciseDetails');
            

            var locals = {
                '$scope': $scope,
                '$rootScope': $rootScope,
                'entity': MockEntity ,
                'Training': MockTraining,
                'ExerciseDetails': MockExerciseDetails
            };
            createController = function() {
                $injector.get('$controller')("TrainingDetailController", locals);
            };
        }));


        describe('Root Scope Listening', function() {
            it('Unregisters root scope listener upon scope destruction', function() {
                var eventType = 'maxwellApp:trainingUpdate';

                createController();
                expect($rootScope.$$listenerCount[eventType]).toEqual(1);

                $scope.$destroy();
                expect($rootScope.$$listenerCount[eventType]).toBeUndefined();
            });
        });
    });

});
