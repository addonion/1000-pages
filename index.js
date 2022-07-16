// Тут код
const puppeteer = require('puppeteer');
const { PuppeteerScreenRecorder } = require('puppeteer-screen-recorder');

const Config = {
  followNewTab: true,
  fps: 25,
  ffmpeg_Path: '<path of ffmpeg_path>' || null,
  videoFrame: {
    width: 1024,
    height: 768,
  },
  aspectRatio: '4:3',
};


//(async () => {
//  const browser = await puppeteer.launch({headless: false});
//  const page = await browser.newPage();
//  await page.goto('https://www.google.ru/webhp?tab=rw');
//  await page.screenshot({path: '../screenshots/google.png'});

 // await browser.close();
//})();

//EXAMPLE:
const recorder = new PuppeteerScreenRecorder(page, Config); // Config is optional
//const recorder = new PuppeteerScreenRecorder(page);

(async () => {
  const browser = await puppeteer.launch();
  const savingPath = '../videos/'; //дописать название видео. Желаельно в название вписать дату и время, в которое началалась запись.
  const page = await browser.newPage();
  const recorder = new PuppeteerScreenRecorder(page);
  await recorder.start(savingPath);
  await page.goto('https://www.carrotquest.io/');

  await page.goto('https://www.carrotquest.io/blog/');
  await recorder.stop();
  await browser.close();
})();