# Battle Entity

Небольшая игра в рамках тестового задания.

К сожалению, далеко не всё реализовано:
  - Нет ограничения по количству атак игрока за один ход
  - Не активна кнопка "Лечить", когда необходимо
  - Графический интерфейс желает ожидать лучшего

Приложение написано для следующих платформ:
- Android
- Desktop

Приложение проверено на следующих устройствах:
- Эмулятор (API 36)
- ПК с ОС Windows 10 средствами среды разработки Android Studio

Технологический стек:
- Среда разработки Android Studio
- Android SDK
- [Kotlin 2.0](https://kotlinlang.org/docs/whatsnew20.html)
- [Kotlin multiplatform](https://kotlinlang.org/docs/multiplatform.html)
- [KotlinX Coroutines (Flow)](https://github.com/Kotlin/kotlinx.coroutines)
- [Jetpack Compose](https://developer.android.com/develop/ui/compose)

Основные модули
- sdk:* - инструменты для разработки
- shared:main - центральная сборка приложения
- app:* - сборка приложения для платформ
