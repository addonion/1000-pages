// Тут код
const puppeteer = require('puppeteer');

(async () => {
  const browser = await puppeteer.launch({headless: false});
  const page = await browser.newPage();
  await page.goto('https://www.google.ru/webhp?tab=rw');
  await page.screenshot({path: '../screenshots/google.png'});

  await browser.close();
})();