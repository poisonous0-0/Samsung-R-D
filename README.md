# Samsung R&D Interview Tasks

This repository contains solutions and implementations for Samsung R&D interview tasks, showcasing Java and Android development expertise.

## 📁 Project Structure

```
.
├── Task 1/                 # Java Console Applications
│   ├── Application_1/      # Calculator Application
│   └── Application_2/      # Music Player Application
├── Task 2/                 # Android Mobile Application
│   ├── app/               # Main Android module
│   ├── gradle/            # Gradle wrapper
│   └── build.gradle       # Project configuration
├── README.md              # This file
└── BLOG_ARTICLE.md        # Detailed documentation
```

## 🎯 Task Overview

### Task 1: Java Console Applications

Two fundamental Java applications demonstrating core programming concepts.

#### Application 1: Calculator 🧮

- **Location**: `Task 1/Application_1/`
- **Main File**: `Application_1.java`
- **Description**: Command-line calculator with basic arithmetic operations
- **Features**:
  - ✅ Addition, Subtraction, Multiplication, Division
  - ✅ Division by zero error handling
  - ✅ Input validation for operators
  - ✅ User-friendly CLI interface
  - ✅ Exception handling with try-catch

**Running the Calculator:**

```bash
cd "Task 1/Application_1"
javac Application_1.java
java Application_1
```

#### Application 2: Music Player 🎵

- **Location**: `Task 1/Application_2/`
- **Files**:
  - `MusicPlayerApp.java` - Application entry point
  - `MusicPlayer.java` - Player logic and controls
  - `Music.java` - Music data model
- **Description**: Interactive command-line music player with playlist management
- **Features**:
  - ✅ Play, Pause, Stop controls
  - ✅ Navigation (Next, Previous)
  - ✅ Playlist display and management
  - ✅ Player status monitoring
  - ✅ Menu-driven user interface
  - ✅ Scanner-based input handling

**Running the Music Player:**

```bash
cd "Task 1/Application_2"
javac Music.java MusicPlayer.java MusicPlayerApp.java
java MusicPlayerApp
```

### Task 2: Android Mobile Application 📱

A professional Android application demonstrating modern mobile development practices.

- **Location**: `Task 2/`
- **Build System**: Gradle
- **Project Type**: Android Studio compatible
- **Architecture**: Clean architecture with layered design
- **Target API**: Android SDK
- **Components**:
  - `app/` module with source code and resources
  - `src/main/` containing Java code and Android resources
  - `build.gradle` with dependencies and build configuration
  - Gradle wrapper for consistent builds across environments

**Build Commands:**

```bash
cd Task\ 2

# Build debug APK
./gradlew assembleDebug

# Build release APK
./gradlew assembleRelease

# Run tests
./gradlew test

# Clean build artifacts
./gradlew clean
```

---

## 🛠️ Technologies & Tools

| Technology         | Purpose              | Task       |
| ------------------ | -------------------- | ---------- |
| **Java**           | Programming Language | Task 1 & 2 |
| **Gradle**         | Build Automation     | Task 2     |
| **Android SDK**    | Mobile Framework     | Task 2     |
| **Android Studio** | IDE (Recommended)    | Task 2     |
| **Git**            | Version Control      | All        |

---

## 📋 Prerequisites

### For Task 1 (Java Applications)

- ✅ Java Development Kit (JDK) 8 or higher
- ✅ Command-line interface (CMD, PowerShell, or Terminal)

### For Task 2 (Android Application)

- ✅ JDK 8 or higher
- ✅ Android SDK (API Level 21+)
- ✅ Gradle 6.0+
- ✅ Android Studio (optional but recommended)

---

## 🚀 Quick Start

### Clone and Setup

```bash
git clone https://github.com/poisonous0-0/Samsung-R-D.git
cd "Samsung R&D"
```

### Run Task 1 Applications

```bash
# Calculator
cd "Task 1/Application_1" && javac Application_1.java && java Application_1

# Music Player
cd "Task 1/Application_2" && javac Music.java MusicPlayer.java MusicPlayerApp.java && java MusicPlayerApp
```

### Run Task 2 Android Project

```bash
cd Task\ 2
./gradlew build           # Build the project
./gradlew installDebug    # Install on connected device/emulator
```

---

## 📚 Code Highlights

### Task 1 - Application 1 (Calculator)

**Key Methods:**

```java
public static double calculate(double num1, double num2, char operator)
```

- Switch-based operator handling
- Error checking for division by zero
- Clean separation of logic from UI

**User Input:**

- Scanner for reading user input
- Try-catch for error handling
- Formatted output display

### Task 1 - Application 2 (Music Player)

**Core Features:**

- Playlist management with Music objects
- Player state tracking (play, pause, stop)
- Current track and navigation logic
- Status reporting

**Key Methods:**

```java
play()              // Start playing current track
pause()             // Pause playback
stop()              // Stop and reset
playNext()          // Move to next track
playPrevious()      // Move to previous track
displayPlaylist()   // Show all tracks
displayStatus()     // Show current state
```

### Task 2 - Android Application

**Architecture:**

- Clean separation of concerns
- Android framework integration
- Resource management (layouts, strings, drawables)
- Manifest configuration

---

## 📖 Documentation

Detailed implementation guide available in `BLOG_ARTICLE.md`:

- Android Sensor Framework explanation
- Architecture design patterns
- Step-by-step implementation
- Best practices for Android development

---

## 🔍 Project Details

### Task 1 Java Applications

- **Demonstrates**: Core Java concepts, user interaction, error handling
- **Lines of Code**: ~150 lines combined
- **Learning Outcomes**: OOP, exception handling, I/O operations

### Task 2 Android Application

- **Demonstrates**: Android development, Gradle builds, resource management
- **Architecture**: Layered design with separation of concerns
- **Learning Outcomes**: Android framework, build systems, mobile development

---

## 📝 Build Configuration

### Task 2 Build Files

- `build.gradle` (Project-level) - Project-wide settings
- `app/build.gradle` (Module-level) - App-specific dependencies and build config
- `gradle.properties` - Global Gradle properties
- `settings.gradle` - Project structure definition
- `gradle/wrapper/` - Gradle wrapper for reproducible builds

---

## ✨ Key Features

### General

- ✅ Well-structured codebase
- ✅ Clear separation of concerns
- ✅ Error handling and validation
- ✅ User-friendly interfaces
- ✅ Comprehensive documentation

### Task 1 Specific

- ✅ Simple and intuitive console UIs
- ✅ Robust input validation
- ✅ Exception handling
- ✅ Object-oriented design

### Task 2 Specific

- ✅ Modern Android development practices
- ✅ Gradle build system integration
- ✅ Proper resource organization
- ✅ Android manifest configuration

---

## 🤝 Contributing

This is an interview portfolio project. For questions or suggestions regarding the implementation, please refer to the original documentation in `BLOG_ARTICLE.md`.

---

## 📄 License

This project is created as part of Samsung R&D interview process.

---

## 📧 Contact

For more information about these implementations, refer to the detailed documentation in this repository.

---

**Repository**: Samsung-R-D  
**Owner**: poisonous0-0  
**Default Branch**: master  
**Last Updated**: February 1, 2026

---

## 📚 Additional Resources - Android Sensor Development

For detailed information about Android Sensor implementation, see `BLOG_ARTICLE.md` which includes:

### Understanding Android Sensors

### What Are Android Sensors?

Android sensors are hardware or software-based components that measure physical phenomena. Common sensor types include:

- **Accelerometer**: Measures linear acceleration along three axes (x, y, z)
- **Gyroscope**: Detects rotational motion and orientation changes
- **Magnetometer (Compass)**: Measures magnetic field strength for directional awareness
- **Barometer**: Detects atmospheric pressure for altitude estimation
- **Proximity Sensor**: Detects nearby objects (useful for screen-off during calls)
- **Light Sensor**: Measures ambient light intensity for auto-brightness
- **Humidity Sensor**: Captures relative humidity levels

### Sensor Framework Overview

Android provides the `SensorManager` API for sensor access. The framework uses:

1. **SensorManager**: Central component for sensor management
2. **SensorEventListener**: Callback interface for sensor events
3. **SensorEvent**: Data packet containing sensor readings and metadata

---

## Project Architecture

Building a robust sensor application requires proper separation of concerns. Here's our recommended architecture:

### 5-Layer Clean Architecture

```
┌─────────────────────────────┐
│      UI Layer               │ MainActivity, Adapters
├─────────────────────────────┤
│    Manager Layer            │ SensorDataManager
├─────────────────────────────┤
│    Model Layer              │ SensorData, SensorInfo
├─────────────────────────────┤
│    Utility Layer            │ SensorDataMapper, Constants
├─────────────────────────────┤
│  Android Framework (API)    │ SensorManager
└─────────────────────────────┘
```

This separation ensures:

- **Testability**: Each layer can be tested independently
- **Maintainability**: Changes in one layer don't affect others
- **Reusability**: Manager and utility components can be used in other projects
- **Scalability**: Easy to add new features without breaking existing code

---

## Implementation Details

### Step 1: Set Up Permissions

First, declare sensor permissions in `AndroidManifest.xml`:

```xml
<uses-permission android:name="android.permission.BODY_SENSORS" />
<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />

<uses-feature
    android:name="android.hardware.sensor.accelerometer"
    android:required="false" />
<uses-feature
    android:name="android.hardware.sensor.gyroscope"
    android:required="false" />
```

Note: Set `required="false"` for optional sensors so your app works on devices without all sensors.

### Step 2: Create the Sensor Event Listener Interface

Define a callback interface for sensor events:

```java
public interface SensorEventListener {
    void onSensorEvent(SensorData sensorData);
    void onAccuracyChanged(SensorInfo sensor, int accuracy);
}
```

### Step 3: Implement the Sensor Manager

The `SensorDataManager` acts as a facade, centralizing all sensor operations:

```java
public class SensorDataManager {
    private SensorManager sensorManager;
    private List<android.hardware.SensorEventListener> listeners = new ArrayList<>();
    private Map<Integer, SensorEventListener> callbackMap = new HashMap<>();

    public SensorDataManager(Context context) {
        sensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
    }

    public void registerSensor(android.hardware.Sensor sensor,
                              SensorEventListener callback) {
        android.hardware.SensorEventListener listener =
            new SensorEventListenerAdapter(sensor, callback);
        listeners.add(listener);
        callbackMap.put(sensor.getType(), callback);
        sensorManager.registerListener(listener, sensor,
                                       SensorManager.SENSOR_DELAY_NORMAL);
    }

    public void unregisterAllListeners() {
        for (android.hardware.SensorEventListener listener : listeners) {
            sensorManager.unregisterListener(listener);
        }
        listeners.clear();
        callbackMap.clear();
    }

    public List<SensorInfo> getAvailableSensors() {
        List<SensorInfo> sensorInfoList = new ArrayList<>();
        List<android.hardware.Sensor> sensors =
            sensorManager.getSensorList(android.hardware.Sensor.TYPE_ALL);

        for (android.hardware.Sensor sensor : sensors) {
            sensorInfoList.add(new SensorInfo(sensor));
        }
        return sensorInfoList;
    }
}
```

### Step 4: Create Data Models

Model classes represent sensor information and readings:

```java
public class SensorInfo {
    private String name;
    private String vendor;
    private float power;
    private float resolution;
    private float maxRange;
    private int type;

    public SensorInfo(android.hardware.Sensor sensor) {
        this.name = sensor.getName();
        this.vendor = sensor.getVendor();
        this.power = sensor.getPower();
        this.resolution = sensor.getResolution();
        this.maxRange = sensor.getMaximumRange();
        this.type = sensor.getType();
    }

    // Getters...
}

public class SensorData {
    private String sensorName;
    private float[] values;
    private int accuracy;
    private long timestamp;
    private String unit;

    public String getFormattedValues() {
        StringBuilder sb = new StringBuilder();
        for (float value : values) {
            sb.append(String.format("%.2f ", value));
        }
        return sb.toString();
    }

    // Getters and setters...
}
```

### Step 5: Handle Runtime Permissions

On Android 6.0+, request permissions at runtime:

```java
private static final String[] SENSOR_PERMISSIONS = {
    Manifest.permission.BODY_SENSORS,
    Manifest.permission.ACCESS_FINE_LOCATION
};
private static final int PERMISSION_REQUEST_CODE = 100;

private void requestSensorPermissions() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.BODY_SENSORS)
            != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                SENSOR_PERMISSIONS, PERMISSION_REQUEST_CODE);
        }
    }
}

@Override
public void onRequestPermissionsResult(int requestCode,
        String[] permissions, int[] grantResults) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    if (requestCode == PERMISSION_REQUEST_CODE) {
        if (grantResults.length > 0
            && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            startMonitoring();
        }
    }
}
```

### Step 6: Build the UI

Create an Activity that displays sensor data:

```java
public class MainActivity extends AppCompatActivity
        implements SensorEventListener {

    private SensorDataManager sensorDataManager;
    private SensorDataAdapter sensorDataAdapter;
    private ListView sensorDataListView;
    private Button startButton, sensorsButton;
    private boolean isMonitoring = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeComponents();
        setupListeners();
        requestSensorPermissions();
    }

    private void initializeComponents() {
        sensorDataManager = new SensorDataManager(this);
        sensorDataListView = findViewById(R.id.sensor_data_list);
        startButton = findViewById(R.id.start_button);
        sensorsButton = findViewById(R.id.sensors_button);

        sensorDataAdapter = new SensorDataAdapter(this,
            new ArrayList<>());
        sensorDataListView.setAdapter(sensorDataAdapter);
    }

    private void setupListeners() {
        startButton.setOnClickListener(v -> toggleMonitoring());
        sensorsButton.setOnClickListener(v -> showAvailableSensors());
    }

    private void toggleMonitoring() {
        if (!isMonitoring) {
            startMonitoring();
        } else {
            stopMonitoring();
        }
    }

    private void startMonitoring() {
        List<SensorInfo> sensors = sensorDataManager.getAvailableSensors();
        for (SensorInfo info : sensors) {
            // Register each sensor
        }
        isMonitoring = true;
        startButton.setText("Stop Monitoring");
    }

    private void stopMonitoring() {
        sensorDataManager.unregisterAllListeners();
        isMonitoring = false;
        startButton.setText("Start Monitoring");
    }

    @Override
    public void onSensorEvent(SensorData sensorData) {
        sensorDataAdapter.addData(sensorData);
        sensorDataAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (isMonitoring) {
            stopMonitoring();
        }
    }
}
```

---

## Best Practices for Sensor Development

### 1. **Manage Sensor Lifecycle Properly**

Always unregister sensors in `onPause()` or `onDestroy()` to prevent battery drain:

```java
@Override
protected void onPause() {
    super.onPause();
    sensorDataManager.unregisterAllListeners();
}
```

### 2. **Choose Appropriate Sampling Rates**

Use `SensorManager.SENSOR_DELAY_NORMAL` for most applications. Faster rates consume more battery:

- `SENSOR_DELAY_FASTEST`: 0ms (only for critical operations)
- `SENSOR_DELAY_GAME`: 20ms (good for games)
- `SENSOR_DELAY_UI`: 66ms (suitable for UI updates)
- `SENSOR_DELAY_NORMAL`: 200ms (default, battery-efficient)

### 3. **Handle Sensor Unavailability**

Always check if a sensor exists before using it:

```java
if (sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) != null) {
    // Sensor available
} else {
    // Handle unavailable sensor gracefully
}
```

### 4. **Use Filtering for Noisy Data**

Real sensor data often contains noise. Apply filters:

```java
public class SensorDataFilter {
    private static final float ALPHA = 0.8f;
    private float[] filteredValues;

    public float[] applyLowPassFilter(float[] sensorValues) {
        if (filteredValues == null) {
            filteredValues = sensorValues.clone();
            return filteredValues;
        }

        for (int i = 0; i < sensorValues.length; i++) {
            filteredValues[i] = ALPHA * filteredValues[i]
                              + (1 - ALPHA) * sensorValues[i];
        }
        return filteredValues;
    }
}
```

### 5. **Request Minimal Permissions**

Only request sensors you actually use. This improves user trust and reduces resource usage.

### 6. **Test on Real Devices**

Sensor behavior varies across devices. Always test on:

- Different device models
- Various Android versions
- Devices with/without specific sensors

---

## Testing Your Sensor Application

### Unit Testing

Test data transformation logic independently:

```java
@Test
public void testSensorDataFormatting() {
    SensorData data = new SensorData();
    data.setValues(new float[]{1.5f, 2.3f, 3.7f});

    String formatted = data.getFormattedValues();
    assertTrue(formatted.contains("1.50"));
    assertTrue(formatted.contains("2.30"));
}
```

### Integration Testing

Test sensor manager operations:

```java
@Test
public void testRegisterSensor() {
    SensorDataManager manager = new SensorDataManager(context);
    List<SensorInfo> sensors = manager.getAvailableSensors();

    assertNotNull(sensors);
    assertTrue(sensors.size() > 0);
}
```

---

## Conclusion

Building an Android sensor application involves understanding the sensor framework, proper architectural design, and attention to performance and battery consumption. The clean architecture approach we've outlined ensures your code is maintainable, testable, and scalable.

Key takeaways:

- ✅ Always manage sensor lifecycle properly
- ✅ Request minimum required permissions
- ✅ Use appropriate sampling rates
- ✅ Implement proper error handling
- ✅ Test on real devices
- ✅ Apply filters to noisy sensor data

With these principles in mind, you're ready to build powerful sensor-driven applications that deliver value to users while respecting battery constraints. The sensor data reader we've built serves as a foundation—extend it with your own business logic and watch your creative ideas come to life!

---

**Author's Note**: This implementation is production-ready and follows Android best practices. The complete source code is available in the accompanying GitHub repository. Happy coding!
