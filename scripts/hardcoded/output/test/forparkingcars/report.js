$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("classpath:hctestcases/getAllRates.feature");
formatter.feature({
  "name": "Get all rates",
  "description": "  AS a car driver\n  I WANT TO get the info about all the available rates\n  SO THAT I can choose the rate of the area I want to park the car at",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Hardcoded rates",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "I request all the rates",
  "keyword": "When "
});
formatter.match({
  "location": "RateStepDefs.iRequestAllTheRates()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should get the following rates:",
  "rows": [
    {
      "cells": [
        "name",
        "costPerHour",
        "minutesAllowedInterval",
        "monday",
        "tuesday",
        "wednesday",
        "thursday",
        "friday",
        "saturday",
        "sunday"
      ]
    },
    {
      "cells": [
        "GREEN_ZONE",
        "0.65 €",
        "60-180",
        "08:00-22:00",
        "08:00-22:00",
        "08:00-22:00",
        "08:00-22:00",
        "08:00-22:00",
        "08:00-22:00",
        "08:00-22:00"
      ]
    },
    {
      "cells": [
        "BLUE_ZONE",
        "0.85 €",
        "35-120",
        "09:00-14:00-17:00-20:00",
        "09:00-14:00-17:00-20:00",
        "09:00-14:00-17:00-20:00",
        "09:00-14:00-17:00-20:00",
        "09:00-14:00-17:00-20:00",
        "10:00-14:00",
        ""
      ]
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "RateStepDefs.iShouldGetTheFollowingRates(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.uri("classpath:hctestcases/issuePermit.feature");
formatter.feature({
  "name": "Issue permit",
  "description": "  AS a car driver\n  I WANT TO get a permit ticket\n  SO THAT I can park the car without being fined",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Hardcoded permit",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "current datetime is \"2020/04/22 08:00\"",
  "keyword": "Given "
});
formatter.match({
  "location": "DateTimeStepDefs.currentDatetimeIs(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I do the following permit issuing request:",
  "rows": [
    {
      "cells": [
        "carPlate",
        "rateName",
        "endingDateTime",
        "cardNumber",
        "cardCvv",
        "cardExpirationDate"
      ]
    },
    {
      "cells": [
        "0000AAA",
        "GREEN_ZONE",
        "2020/04/22 10:00",
        "1234567890123456",
        "123",
        "2025/06"
      ]
    }
  ],
  "keyword": "When "
});
formatter.match({
  "location": "PermitStepDefs.iDoTheFollowingPermitIssuingRequest(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should get the following permit ticket:",
  "rows": [
    {
      "cells": [
        "code",
        "carPlate",
        "rateName",
        "startingDateTime",
        "endingDateTime",
        "price"
      ]
    },
    {
      "cells": [
        "PT/0000000000/202004220800",
        "0000AAA",
        "GREEN_ZONE",
        "2020/04/22 08:00",
        "2020/04/22 10:00",
        "1.30 €"
      ]
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "PermitStepDefs.iShouldGetTheFollowingPermitTicket(DataTable)"
});
formatter.result({
  "status": "passed"
});
});