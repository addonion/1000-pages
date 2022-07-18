const { chromium } = require("playwright");
const { saveVideo } = require("playwright-video");

/* Адрес сайта */
const siteUrl = "https://carrotquest.io/";

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
  // Ждём 5 секунд
  await page.waitForTimeout(8000);
  await browser.close();

  console.log(`Видео сайта — ${clearUrl(siteUrl)} — успешно сохранено!`);
})();
