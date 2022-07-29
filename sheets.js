//подключение модулей
const { google } = require("googleapis");
const keys = require("./keys.json");


const client = new google.auth.JWT(

    keys.client_email,
    null,
    keys.private_key,
    ["https://www.googleapis.com/auth/spreadsheets"]

);


client.authorize(function (err, tokens) {

    if (err){
        console.log(err);
        return;
    }
    else {
        console.log("Connected!");
    }

});


async function gsrun(cl) {

    const gsapi = google.sheets({ version: "v4", auth: cl });

    const opt = {
        spreadsheetId: "1m4ztxgzrTEKydp-1VnmjYQ2hb6DerfANeefA8mnpZGo",
        range: "Sites URL!A1:C4"
    }

    let data = await gsapi.spreadsheets.values.get(opt);
    let dataArray = data.data.values;

    let newDataArray = dataArray.map(function(r){
        r.push(r[0] + '-' + r[1]);
        return r;
    });

    console.log(newDataArray);

    //40.17
}

gsrun(client);