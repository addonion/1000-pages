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
    console.log(data.data.values);

    //30.25
}

gsrun(client);