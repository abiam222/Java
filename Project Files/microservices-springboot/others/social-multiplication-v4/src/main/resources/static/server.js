const bodyParser = require("body-parser"),
    express = require("express"),
    path = require('path');

const app = express();
const PORT = process.env.PORT || 4000;

// BodyParser makes it easy for our server to interpret data sent to it.
// The code below is pretty standard.
app.use(bodyParser.json({ type: 'application/vnd.api+json' }));
app.use(bodyParser.urlencoded({ extended: true }));
app.use(bodyParser.text());

app.use(express.static(path.join(__dirname, './')));

//Server Listener
app.listen(PORT, function () {
    console.log("App listening on PORT: " + PORT);
});