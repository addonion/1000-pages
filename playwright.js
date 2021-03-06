//функции
function GetArray(doc){
  await doc.useServiceAccountAuth({
    // env var values are copied from service account credentials generated by google
    // see "Authentication" section in docs for more info
    client_email: "sa1000-pages@pages-356911.iam.gserviceaccount.com",
    private_key: "-----BEGIN PRIVATE KEY-----\nMIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCzHgzO9VjWEGtC\n4atol+TmMg5xk1mIIavMoG6zfYmSy2Ws3V4e0Q4MgKRAgYZxpSc1JKexTqOoNf19\nDs2ZZHtB9yqMkovHTqITIrtA3aEWzrcawXSbBZMLIXzvvlQUbhTxh3vBdJyZHGy1\nPNRVK5L+4jD24bRIoruTaFFvsfkr2o69IYtboUbpCneQTZc/4NoDN7wJYX80txBo\nrgPQTLbLnhVgIZhlf8qwgP6O996dwhaX7W5X6CiIIyPCvYGcfHsfKAe0Pw2IoYd1\nm4WKnMNRbPIPRQZc5GzTXeqxw6yusDaSCxdlVYTfaM37WU0pkOD4CjjY/FfQo9uI\ntVL5Yw41AgMBAAECggEAGn2Evmz5vPsDqgoPHDJut37KtRBqSuBT9Lj7dk9IM+4h\n9O1uWJdpgP7bi/C8Df2zbUAlDuuG9784ZLD2RkvekNR5tf2Mb6cZAESANikxBFsB\nKJNY5/5sj1ZeEGTxMW5QaaI0ctmIuXpDN5CuBISjwk94l2KtE5sBq9zfQmorZEk4\nhHltJbBEIEiTa/4RhkcbM6pEDP5S9Ld2rnX8lM8dyiNOQ+/ymYg/x+lWQ5UGQMfL\nFig+mLISbQSNyqM9i/+9Yd+Zy1dIjnR624Xacfij+LrJtipNUfAi6n7ee2dbZq/n\n0x6fxW/bUSfaHiR3e73Oe8YP5j818472ufL9mSgg1wKBgQDpel71Xu4DDe0c1wT/\n/X0zFTflGm2hCDSgY+xVtemuG8ubhFJWJK6aIcdVuqfZKTGXr55YVegX1PL4QMt4\ndPuYZ2vOppMiiU8r4zHVzHnJ5+zkBmMLWhOVMIIU41PRdXna6HCMZRN+XIxqpMBB\nCKda97PUE/vYgZ6CjdfErltbcwKBgQDEZUTjG41NbdQ2shznmJT6Mzn+VWHgO6Hz\nMlbrxIdjP1fpsc8BxLXYRUUVsHNP9L3Skb9bf/SZYW4IRMmHHvA3UBuG2hzpdYqp\nAyks9Ericz1MsuXFY1BWdsTvuQVauiKgusyi9Iptfe445ODELSIlLBMoKJzQAQPI\nH+p/HYrVtwKBgEclvjghlIAjx0TJlUF4+qUNazoKgqvWt0rFCGjaBXrEB5i9iuWr\nSfW4I2lRdwKrFey2XJdonlBc2SmjfR2Y8G5x3Z1cj2uv0gt6sV4IcHiBj2OxOo9k\nBKGq5Yj9+TXUCa0Wte1ig7028Kcyy09GFtGWuBsBd/ZzEV2RYdYSl85XAoGAA3SI\npro4XTFed2vgyE5N6Kz4CzpzU1+ZNM8g6lr1ytA1er4PF0ffryNg2MXW8YQrxsWb\nqT9yDTTCm9Ch/weTUFXPdirmMVFJFDojAlB19M/0NyI6mqNpqWvDgTgvGO6HZ26B\n5SgKO2zowQV90tW8cQz6dU1pnNs3ttCg7oWViLcCgYAZvMFxDyWw3kEO2gI628qX\n4X9yoGQQeP597y5xT5h6cFK/HE34c4mNnQufHK0vJ/AtY+z9gc2tLa+4iZ9Xc2dA\nS9oBXUbphPNZReaD3OOt9gbiV1Cj5f7Rri/10dbqpm+25uW+BDcz3CI0TLrTiDqa\nuosRBzDo1MtbC7x+q0FMZw==\n-----END PRIVATE KEY-----\n",
  });

  await doc.loadInfo(); // loads document properties and worksheets
  const sheet = doc.sheetsByIndex[0]; // or use doc.sheetsById[id] or doc.sheetsByTitle[title]
  

  //const rows = await sheet.getRows();
  //const arr = [];

  //rows.array.forEach(element => {
    //let row = new Object(
      //siteUrl = element[0],
      //title = element[1],
      //description = element[2]
    //)
    //arr.push(row);
  //});

  //return arr;
}


const { chromium } = require("playwright");
const { saveVideo } = require("playwright-video");
const { GoogleSpreadsheet } = require('google-spreadsheet');

/* Адрес сайта */
const siteUrl = "https://carrotquest.io/";

const tableUrl = "https://docs.google.com/spreadsheets/d/1m4ztxgzrTEKydp-1VnmjYQ2hb6DerfANeefA8mnpZGo/edit#gid=0";
const tableId = "0";
const doc = new GoogleSpreadsheet(tableId);


/* Очистка адреса для файла */
function clearUrl(url) {
  return url.replace("https://", "").replace("http://", "").replace("/", "");
}

/* Запись видео
 * headless позволяет загрузить бабл чата
 * задержка стоит на 5000мс = 5 секунд
 */
(async () => {
  const browser = await chromium.launch({
    headless: false,
  });
  const context = await browser.newContext();
  const page = await context.newPage();

  // Сохраняем видео
  await saveVideo(page, `./result/${clearUrl(siteUrl)}.mp4`);

  // Заходим на страницу и ждём загрузки
  await page.goto(siteUrl, { waitUntil: "networkidle" });
  await page.waitForTimeout(2000);
  await page.locator("#icon-container").click();
  // Ждём 8 секунд
  await page.waitForTimeout(8000);
  await browser.close();

  console.log(`Видео сайта — ${clearUrl(siteUrl)} — успешно сохранено!`);
  //let array = 
  GetArray(doc);
  //console.log(array);
})();
await GetArray(doc);