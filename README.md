Создание мультиплатформенного сетевого слоя с помощью KMM и openapi-generator
Цель: Научится собирать мультиплатформу с кодогенерацией
1. Установить IDEA Community Edition https://www.jetbrains.com/idea/download
2. Создать мультиплатформенный проект как показано было на занятии
3. Пересоздать для SwiftUI iosApp как показано было на занятии
Генерация сетевого слоя:
4. Обновить openapi-generator c помощью brew install openapi-generator или через https://github.com/icerockdev/moko-network
5. Можно взять из материалов recipepuppy_openapi.yaml (нужно в Info.plist разрешить http) или найти другое публично апи и написать спеку https://github.com/public-apis/public-apis
6. Сгенерировать сетевой слой openapi-generator generate -g kotlin -i recipepuppy_openapi.yaml --library multiplatform -o NetworkLayer (показывается на занятии)
Настойка КMM:
7. Подключить в build.gradle io.ktor и kotlinx.serialization
8. Сбилдить KMM в IDEA и затем app фреймвок в Xcode
9. Вывести рецепты в SwiftUI лист по нескольким ингридиентам или поиском (частично показано в конце занятия)

Можно использовать шаблоны KMM + SwiftUI типа https://github.com/joreilly/PeopleInSpace
