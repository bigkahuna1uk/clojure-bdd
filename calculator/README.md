# calculator

BDD example in Clojure for a calculator

## Usage

Use the following to run all tests and produce a HTML report

```bash
lein clean && lein cucumber  --plugin html:target/test-reports
```

or JSON

```bash
lein clean && lein cucumber  --plugin json:target/test-reports.json
```

## License

Copyright © 2017 

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
