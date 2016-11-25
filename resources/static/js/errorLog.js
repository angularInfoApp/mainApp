var loggingModule = angular.module('loggerModule', []);

/**
 * Application Logging Service to give us a way of logging
 * error / debug statements from the client to the server.
 */
loggingModule.factory(
    "applicationLoggingService",
    ["$log","$window",function($log, $window){
        return({
            error: function(message){
                // preserve default behaviour
                $log.error.apply($log, arguments);
                // send server side
                $.ajax({
                    type: "POST",
                    url: "/logger",
                    contentType: "application/json",
                    data: angular.toJson({
                        url: $window.location.href,
                        message: message,
                        type: "error"
                    })
                });
            },
            debug: function(message){
                $log.log.apply($log, arguments);
                $.ajax({
                    type: "POST",
                    url: "/clientlogger",
                    contentType: "application/json",
                    data: angular.toJson({
                        url: $window.location.href,
                        message: message,
                        type: "debug"
                    })
                });
            }
        });
    }]
);