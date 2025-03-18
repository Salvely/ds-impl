#include <doctest/doctest.h>
#include <dsproject/dsproject.h>
#include <dsproject/version.h>

#include <string>

TEST_CASE("Greeter") {
  using namespace dsproject;

  Greeter dsproject("Tests");

  CHECK(dsproject.greet(LanguageCode::EN) == "Hello, Tests!");
  CHECK(dsproject.greet(LanguageCode::DE) == "Hallo Tests!");
  CHECK(dsproject.greet(LanguageCode::ES) == "¡Hola Tests!");
  CHECK(dsproject.greet(LanguageCode::FR) == "Bonjour Tests!");
}

TEST_CASE("Greeter version") {
  static_assert(std::string_view(DSPROJECT_VERSION) == std::string_view("1.0"));
  CHECK(std::string(DSPROJECT_VERSION) == std::string("1.0"));
}
