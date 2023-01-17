<a name="readme-top"></a>

<!-- PROJECT LOGO -->

<Banner Here>

<br />
<div align="center">

![Simple Bot v3](https://user-images.githubusercontent.com/111836326/212888314-ffb61f50-61d6-4f53-93e1-1d733024c78f.png)

<h2 align="center">Simple Bot V3.0</h2>

  <p align="center">
    Just a simple Java telegram bot, dockerized & deployed on Render
    <br />
    <a href="https://github.com/nc1z/simple-bot-telegram"><strong>Explore the docs »</strong></a>
    <br />
    <br />
    <a href="https://t.me/simple_v1_bot">View Demo</a>
    ·
    <a href="https://github.com/nc1z/simple-bot-telegram">Report Bug</a>
    ·
    <a href="https://github.com/nc1z/simple-bot-telegram">Request Feature</a>
  </p>
</div>

<hr/>

<!-- ABOUT THE PROJECT -->

## About The Project

A simple telegram bot project that users can interact with to get quotes and jokes! Currently in development.

<!-- RELEASE -->

## Release & Updates

- V3.0 - Bot is now able to respond with jokes or quotes.
- V2.0 - Bot is live and able to respond with basic greetings & date.
- V1.0 - Testing Phase. Undeployed.

<!-- BOT COMMANDS -->

## Example Commands (UPDATED: V3.0)

Simple bot uses keywords to detect and provde a response accordingly. Some examples below:

```
Prefixed with /bot:
- hello
- what day is it?
- tell me a joke
- give me a quote
```

<!-- USAGE -->

## Usage

1. Clone Repository
2. Open project in your favorite IDE (IntelliJ, Eclipse etc.)
3. Build/install maven dependencies
4. Create a new java class for your bot, and register in main class (See <a href="https://github.com/rubenlagus/TelegramBots" target="_blank">here</a>)
5. Enter your bot username and key, Created and retrieved from @BotFather on telegram (See <a href="https://core.telegram.org/bots" target="_blank">here</a>)
6. Start your application and test it out with the commands available here.

### Running Docker Container Locally

1. Make sure to have a Dockerfile in your project root (See this repository for an example)
2. Make sure you have Docker and its CLI installed.
3. Build the docker image

```
docker build -t dockerImageNameOfYourChoice --build-arg BOT_KEY=YourBotKeyHere --build-arg BOT_USERNAME=YourBotUsernameHere .
```

4. Run the image in a container, and port forward to 8080 if you want to create APIs

```
docker run -p 8080:8080 dockerImageNameYouCreated
```

<!-- CONTACT -->

## Contact

- https://github.com/nc1z

Project Link: https://github.com/nc1z/simple-bot-telegram

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- ACKNOWLEDGMENTS -->

## Acknowledgments

- https://github.com/rubenlagus/TelegramBots
- https://zenquotes.io/
- https://github.com/15Dkatz/official_joke_api

<p align="right">(<a href="#readme-top">back to top</a>)</p>
