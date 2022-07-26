const { google } = require("googleapis");
const keys = require("./keys.json");


function CreateClient(){
    let client = new google.auth.JWT(

        keys.client_email,
        null,
        keys.private_key,
        ["https://www.googleapis.com/auth/spreadsheets"]);

        

    return client;
}

function CreateOptions(sheetId, sheetTitle, startCell, finalCell){
    let options = {
        spreadsheetId: sheetId,
        range: `${sheetTitle}!${startCell}:${finalCell}`
    };

    return options;
}

async function GetUrls(client, options){
    const gsapi = google.sheets({ version: "v4", auth: client });

    let data = await gsapi.spreadsheets.values.get(options);
    let dataArray = data.data.values;

    let urls = [];
    dataArray.forEach(el => urls.push(el));
    return urls;
}

async function gsrun(client, options){
    let urls = GetUrls(client, options);
    console.log(urls);
}



const client = CreateClient();
client.authorize(function (err, tokens) {

    if (err){
        console.log(err);
        return;
    }
    else {
        console.log("Connected!");
    }
});
let options = CreateOptions('1m4ztxgzrTEKydp-1VnmjYQ2hb6DerfANeefA8mnpZGo', 'Sites URL', 'A2', 'A4');
gsrun(client, options);