# json-diff-utils

This project compares 2 json converted to string and returns a json containing the differences between them.
The library used to compare JSON is [Guava](https://github.com/google/guava)

## Input params

It is necessary to send 2 json files in string format
Example:

String json1 = "{\"name\":\"Mike\", \"city\":\"Lisbon\", \"state\":\"Lisbon\"}";
String json2 = "{\"city\":\"New York\", \"street\":\"20 Cooper Square\", \"name\":\"John\"}";

## Method name

compareJsonDiff(String json1, String json2)

## How to use

1 - Create jar with dependencies using the maven command:

```bash
mvn package
```

This command will create 2 jars:
One without the dependencies used in the project (json-diff-1.0.jar) and the other with all the dependencies to be able to use it directly (json-diff-1.0-jar-with-dependencies.jar).

We will use the jar with all the dependencies. The name of the jar is: <b>json-diff-1.0-jar-with-dependencies.jar</b>

2 - After create the jar file, on the command line execute:

```bash
java -cp json-diff-1.0-jar-with-dependencies.jar com.paruuy.jsondiff.JsonDiffApp "{\"name\":\"Mike\", \"city\":\"Lisbon\", \"state\":\"Lisbon\"}" "{\"city\":\"New York\", \"street\":\"20 Cooper Square\", \"name\":\"John\"}"
```

3 - The command return a json string with this format:

```json
{
    "result": [
        {
            "nodes": [
                {
                    "path": "/city",
                    "value": "Lisbon",
                    "json_source": "JSON_1"
                },
                {
                    "path": "/city",
                    "value": "New York",
                    "json_source": "JSON_2"
                }
            ]
        },
        {
            "nodes": [
                {
                    "path": "/name",
                    "value": "Mike",
                    "json_source": "JSON_1"
                },
                {
                    "path": "/name",
                    "value": "John",
                    "json_source": "JSON_2"
                }
            ]
        }
    ]
}
```

### Aditional info

```java
//If you need to show the entries only of json1, you can print:
difference.entriesOnlyOnLeft().forEach((key, value) -> System.out.println(key + ": " + value));

//If you need to show the entries only of json2, you can print:
difference.entriesOnlyOnRight().forEach((key, value) -> System.out.println(key + ": " + value));

```
