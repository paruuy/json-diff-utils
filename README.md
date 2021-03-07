# json-diff-utils
This priject compares 2 json strings and shows the differences between them returning the vaule as a json string


## Input params
It is necessary to send 2 json files in string format
Example:

String json1 = ""

## Method name
compareJsonDiff(String json1, String json2)



´´´
//If you need to show the entries only of json1, you can print:
difference.entriesOnlyOnLeft().forEach((key, value) -> System.out.println(key + ": " + value));

//If you need to show the entries only of json2, you can print:
difference.entriesOnlyOnRight().forEach((key, value) -> System.out.println(key + ": " + value));

´´´
