package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.ui.theme.*

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      MyApplicationTheme {
        PortfolioSleekApp(modifier = Modifier.fillMaxSize())
      }
    }
  }
}

@Composable
fun PortfolioSleekApp(modifier: Modifier = Modifier) {
  var selectedTab by remember { mutableStateOf("Home") }

  Scaffold(
    modifier = modifier,
    containerColor = MaterialTheme.colorScheme.background,
    bottomBar = { 
        BottomNavigationBar(
            selectedTab = selectedTab,
            onTabSelected = { selectedTab = it }
        ) 
    }
  ) { innerPadding ->
    LazyColumn(
      modifier = Modifier.padding(innerPadding).fillMaxSize(),
      contentPadding = PaddingValues(top = 24.dp, bottom = 24.dp)
    ) {
      item { HeaderSection() }
      
      when (selectedTab) {
        "Home" -> {
          item { HeroSection() }
          item { ContentSection() }
        }
        "Projects" -> {
          item { ProjectsSection() }
        }
        "About" -> {
          item { SkillsSection() }
        }
        "Contact" -> {
          item { ContactSection() }
        }
      }
    }
  }
}

@Composable
fun HeaderSection() {
  Row(
    modifier = Modifier
      .fillMaxWidth()
      .padding(horizontal = 24.dp, vertical = 12.dp),
    horizontalArrangement = Arrangement.SpaceBetween,
    verticalAlignment = Alignment.CenterVertically
  ) {
    Box(
      modifier = Modifier
        .size(48.dp)
        .clip(CircleShape)
        .background(MaterialTheme.colorScheme.primaryContainer),
      contentAlignment = Alignment.Center
    ) {
      Text(
        text = "JK",
        style = MaterialTheme.typography.titleLarge,
        color = MaterialTheme.colorScheme.onPrimaryContainer,
        fontWeight = FontWeight.Bold
      )
    }
    IconButton(
      onClick = { },
      modifier = Modifier
        .size(48.dp)
        .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f), CircleShape)
    ) {
      Icon(
        imageVector = Icons.Outlined.Settings,
        contentDescription = "Settings",
        tint = MaterialTheme.colorScheme.onSurfaceVariant
      )
    }
  }
}

@Composable
fun HeroSection() {
  Column(
    modifier = Modifier
      .fillMaxWidth()
      .padding(horizontal = 24.dp, vertical = 24.dp)
  ) {
    Row(
      modifier = Modifier.fillMaxWidth(),
      verticalAlignment = Alignment.CenterVertically
    ) {
      Box(modifier = Modifier.size(108.dp)) {
        Image(
          painter = painterResource(id = R.drawable.img_jaakko_avatar_1782011001790),
          contentDescription = "Profile Picture",
          modifier = Modifier
            .size(100.dp)
            .clip(CircleShape)
            .border(3.dp, MaterialTheme.colorScheme.primary, CircleShape),
          contentScale = ContentScale.Crop
        )
        Box(
          modifier = Modifier
            .align(Alignment.BottomEnd)
            .padding(bottom = 8.dp, end = 8.dp)
            .size(24.dp)
            .clip(CircleShape)
            .background(Color(0xFF4CAF50))
            .border(3.dp, MaterialTheme.colorScheme.background, CircleShape)
        )
      }
      
      Spacer(modifier = Modifier.width(20.dp))
      
      Column {
        Surface(
          shape = RoundedCornerShape(16.dp),
          color = MaterialTheme.colorScheme.primaryContainer,
          modifier = Modifier.padding(bottom = 8.dp)
        ) {
          Row(
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
            verticalAlignment = Alignment.CenterVertically
          ) {
            Box(
              modifier = Modifier
                .size(8.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.primary)
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
              text = "Available for work",
              style = MaterialTheme.typography.labelMedium,
              fontWeight = FontWeight.Bold,
              color = MaterialTheme.colorScheme.onPrimaryContainer
            )
          }
        }
        Text(
            text = "Helsinki, FIN",
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
      }
    }

    Spacer(modifier = Modifier.height(32.dp))
    Text(
      text = "Hi, I'm ",
      style = MaterialTheme.typography.displayMedium,
      color = MaterialTheme.colorScheme.onBackground
    )
    Text(
      text = "Jaakko Kallio.",
      style = MaterialTheme.typography.displayMedium.copy(fontWeight = FontWeight.Bold),
      color = MaterialTheme.colorScheme.primary
    )
    Spacer(modifier = Modifier.height(16.dp))
    Text(
      text = "Senior Full Stack Engineer",
      style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.SemiBold),
      color = MaterialTheme.colorScheme.onSurface
    )
    Spacer(modifier = Modifier.height(12.dp))
    Text(
      text = "I specialize in building scalable, secure, and performant digital experiences. With a passion for clean code and intuitive design, I bring complex software solutions to life—from robust backend architectures to polished, engaging frontends.",
      style = MaterialTheme.typography.bodyLarge,
      color = MaterialTheme.colorScheme.onSurfaceVariant
    )
    Spacer(modifier = Modifier.height(32.dp))
    Row(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
      Button(
        onClick = { },
        shape = RoundedCornerShape(16.dp),
        contentPadding = PaddingValues(horizontal = 24.dp, vertical = 14.dp),
        modifier = Modifier.weight(1f)
      ) {
        Icon(
          imageVector = Icons.Outlined.Description,
          contentDescription = null,
          modifier = Modifier.size(20.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text("Resume", fontWeight = FontWeight.SemiBold)
      }
      FilledTonalButton(
        onClick = { },
        shape = RoundedCornerShape(16.dp),
        contentPadding = PaddingValues(horizontal = 24.dp, vertical = 14.dp),
        modifier = Modifier.weight(1f)
      ) {
        Icon(
          imageVector = Icons.Outlined.ChatBubbleOutline,
          contentDescription = null,
          modifier = Modifier.size(20.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text("Contact", fontWeight = FontWeight.SemiBold)
      }
    }
  }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ContentSection() {
  Column(
    modifier = Modifier
      .fillMaxWidth()
      .padding(horizontal = 16.dp),
    verticalArrangement = Arrangement.spacedBy(16.dp)
  ) {
    // Featured Project Card
    Card(
      shape = RoundedCornerShape(28.dp),
      colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
      modifier = Modifier.fillMaxWidth().clickable { }
    ) {
      Column(modifier = Modifier.padding(24.dp)) {
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.SpaceBetween,
          verticalAlignment = Alignment.Top
        ) {
          Icon(
            imageVector = Icons.Outlined.RocketLaunch,
            contentDescription = "Featured Project",
            tint = MaterialTheme.colorScheme.onPrimaryContainer,
            modifier = Modifier.size(32.dp)
          )
          Surface(
            color = MaterialTheme.colorScheme.onPrimaryContainer,
            shape = CircleShape
          ) {
            Text(
              text = "FEATURED",
              style = MaterialTheme.typography.labelSmall,
              color = MaterialTheme.colorScheme.primaryContainer,
              modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp),
              fontWeight = FontWeight.Bold
            )
          }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
          text = "Project Zenith",
          style = MaterialTheme.typography.titleLarge,
          color = MaterialTheme.colorScheme.onPrimaryContainer
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
          text = "A high-performance cloud monitoring dashboard built with React and Go.",
          style = MaterialTheme.typography.bodyMedium,
          color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.8f)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
          SkillChip("TYPESCRIPT")
          SkillChip("AWS")
        }
      }
    }

    // Grid row
    Row(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
      StatsCard(
        icon = Icons.Outlined.Terminal,
        title = "Tech Stack",
        subtitle = "12+ Technologies",
        modifier = Modifier.weight(1f)
      )
      StatsCard(
        icon = Icons.Outlined.HistoryEdu,
        title = "Experience",
        subtitle = "5 Years Active",
        modifier = Modifier.weight(1f)
      )
    }

    // Contact Card
    Card(
      shape = RoundedCornerShape(28.dp),
      colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
      border = androidx.compose.foundation.BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
      modifier = Modifier.fillMaxWidth().clickable { }
    ) {
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .padding(24.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Row(
          horizontalArrangement = Arrangement.spacedBy(16.dp),
          verticalAlignment = Alignment.CenterVertically
        ) {
          Box(
            modifier = Modifier
              .size(40.dp)
              .background(MaterialTheme.colorScheme.primary, CircleShape),
            contentAlignment = Alignment.Center
          ) {
            Icon(
              imageVector = Icons.Outlined.Mail,
              contentDescription = "Mail",
              tint = MaterialTheme.colorScheme.onPrimary,
              modifier = Modifier.size(20.dp)
            )
          }
          Column {
            Text(
              text = "Get in touch",
              style = MaterialTheme.typography.titleMedium,
              color = MaterialTheme.colorScheme.onSurface
            )
            Text(
              text = "Available for hire",
              style = MaterialTheme.typography.bodySmall,
              color = MaterialTheme.colorScheme.onSurfaceVariant
            )
          }
        }
        Icon(
          imageVector = Icons.Outlined.ChevronRight,
          contentDescription = "Go",
          tint = MaterialTheme.colorScheme.onSurfaceVariant
        )
      }
    }
  }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ProjectsSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Text(
            text = "Projects",
            style = MaterialTheme.typography.displaySmall,
            color = MaterialTheme.colorScheme.onBackground
        )
        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            val cardModifier = Modifier.weight(1f).widthIn(min = 300.dp)
            DetailedProjectCard(
                title = "Project Zenith",
                description = "A high-performance cloud monitoring dashboard built with React and Go. Features real-time data streaming, customizable widgets, and fine-grained access control. Orchestrated scaling using Docker and Kubernetes to handle rapid telemetry data ingest.",
                technologies = listOf("React", "Go", "TypeScript", "AWS", "WebSockets"),
                linkText = "Live Demo",
                linkAction = "https://jaakko-cv-477864421305.us-west1.run.app/",
                imageRes = R.drawable.project_zenith_screenshot_1780108220520,
                modifier = cardModifier
            )
            DetailedProjectCard(
                title = "CryptoDash",
                description = "Real-time cryptocurrency tracking dashboard. Uses Flow and Coroutines for state management, with custom canvas charts for price history visualization. Secured by an encrypted local Room database for offline accessibility.",
                technologies = listOf("Kotlin", "Jetpack Compose", "Coroutines", "Retrofit", "Room"),
                linkText = "View Repository",
                linkAction = "https://github.com/jaakko-kallio/cryptodash",
                imageRes = R.drawable.project_crypto_screenshot_1780108239260,
                modifier = cardModifier
            )
            DetailedProjectCard(
                title = "AeroSync Automation",
                description = "An automated CI/CD pipeline management tool that bridges GitHub actions with internal Jenkins clusters. Provides an intuitive web view of build streams and code quality coverage reports.",
                technologies = listOf("Node.js", "Express", "TailwindCSS", "Jenkins API"),
                linkText = "Source Code",
                linkAction = "https://github.com/jaakko-kallio/aerosync",
                imageRes = R.drawable.project_aerosync_screenshot_1780108259454,
                modifier = cardModifier
            )
            DetailedProjectCard(
                title = "FocusFlow Notes",
                description = "A minimalistic, distraction-free markdown note-taking app with instant multi-device syncing over Firebase. Features theming capabilities, rich-text rendering via markdown parsing, and collaborative real-time editing.",
                technologies = listOf("Android", "Java", "Firebase", "Material Design"),
                linkText = "Get it on Play Store",
                linkAction = "https://play.google.com/store/apps/details?id=com.jaakko.focusflow",
                imageRes = R.drawable.project_focusflow_screenshot_1780108276194,
                modifier = cardModifier
            )
        }
    }
}

@Composable
fun DetailedProjectCard(
    title: String,
    description: String,
    technologies: List<String>,
    linkText: String,
    linkAction: String,
    imageRes: Int,
    modifier: Modifier = Modifier
) {
    val uriHandler = androidx.compose.ui.platform.LocalUriHandler.current
    Card(
        shape = RoundedCornerShape(28.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
        modifier = modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(24.dp)) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .border(BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant), RoundedCornerShape(16.dp))
                    .background(MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.5f)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = imageRes),
                    contentDescription = "$title Screenshot",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onSurface
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(modifier = Modifier.height(16.dp))
            
            Text(
                text = "Key Technologies",
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            @OptIn(ExperimentalLayoutApi::class)
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                technologies.forEach { tech ->
                    SkillChip(tech)
                }
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .clickable { uriHandler.openUri(linkAction) }
                    .padding(8.dp)
            ) {
                Icon(
                    imageVector = Icons.Outlined.Link,
                    contentDescription = linkText,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = linkText,
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}

@Composable
fun SkillsSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Text(
            text = "Skills & Expertise",
            style = MaterialTheme.typography.displaySmall,
            color = MaterialTheme.colorScheme.onBackground
        )
        SkillCategory(
            title = "Programming Languages",
            skills = listOf(
                Pair("Kotlin", 0.9f),
                Pair("Java", 0.8f),
                Pair("TypeScript", 0.7f),
                Pair("Go", 0.6f)
            )
        )
        SkillCategory(
            title = "Frameworks & UI",
            skills = listOf(
                Pair("Jetpack Compose", 0.95f),
                Pair("React", 0.8f),
                Pair("Coroutines & Flow", 0.85f),
                Pair("Tailwind CSS", 0.9f)
            )
        )
        SkillCategory(
            title = "Tools & Infrastructure",
            skills = listOf(
                Pair("Git & GitHub", 0.9f),
                Pair("Firebase", 0.8f),
                Pair("AWS", 0.65f),
                Pair("Docker", 0.7f)
            )
        )
    }
}

@Composable
fun SkillCategory(title: String, skills: List<Pair<String, Float>>) {
    Card(
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(24.dp)) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(16.dp))
            skills.forEach { (skill, proficiency) ->
                Column(modifier = Modifier.padding(bottom = 12.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = skill,
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                    Spacer(modifier = Modifier.height(6.dp))
                    LinearProgressIndicator(
                        progress = { proficiency },
                        modifier = Modifier.fillMaxWidth().height(6.dp).clip(RoundedCornerShape(3.dp)),
                        color = MaterialTheme.colorScheme.primary,
                        trackColor = MaterialTheme.colorScheme.surfaceVariant
                    )
                }
            }
        }
    }
}

@Composable
fun ContactSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Text(
            text = "Contact",
            style = MaterialTheme.typography.displaySmall,
            color = MaterialTheme.colorScheme.onBackground
        )
        Card(
            shape = RoundedCornerShape(28.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
            modifier = Modifier.fillMaxWidth().clickable { }
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .background(MaterialTheme.colorScheme.primary, CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Mail,
                            contentDescription = "Mail",
                            tint = MaterialTheme.colorScheme.onPrimary,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                    Column {
                        Text(
                            text = "Email Me",
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Text(
                            text = "jaakko.kkallio@gmail.com",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        }

        Card(
            shape = RoundedCornerShape(28.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
            modifier = Modifier.fillMaxWidth().clickable { }
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .background(MaterialTheme.colorScheme.secondaryContainer, CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Link,
                            contentDescription = "LinkedIn",
                            tint = MaterialTheme.colorScheme.onSecondaryContainer,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                    Column {
                        Text(
                            text = "LinkedIn",
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Text(
                            text = "Let's connect",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun SkillChip(text: String) {
  Surface(
    shape = RoundedCornerShape(6.dp),
    color = MaterialTheme.colorScheme.surface.copy(alpha = 0.4f)
  ) {
    Text(
      text = text,
      style = MaterialTheme.typography.labelSmall,
      color = MaterialTheme.colorScheme.onPrimaryContainer,
      modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
      fontWeight = FontWeight.SemiBold
    )
  }
}

@Composable
fun StatsCard(icon: ImageVector, title: String, subtitle: String, modifier: Modifier = Modifier) {
  Card(
    shape = RoundedCornerShape(28.dp),
    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.5f)),
    modifier = modifier.clickable { }
  ) {
    Column(modifier = Modifier.padding(20.dp)) {
      Icon(
        imageVector = icon,
        contentDescription = title,
        tint = MaterialTheme.colorScheme.primary,
        modifier = Modifier.padding(bottom = 8.dp)
      )
      Text(
        text = title,
        style = MaterialTheme.typography.titleMedium,
        color = MaterialTheme.colorScheme.onBackground
      )
      Text(
        text = subtitle,
        style = MaterialTheme.typography.bodySmall,
        color = MaterialTheme.colorScheme.onSurfaceVariant
      )
    }
  }
}

@Composable
fun BottomNavigationBar(selectedTab: String, onTabSelected: (String) -> Unit) {
  Surface(
    color = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.5f),
    tonalElevation = 0.dp
  ) {
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 16.dp, vertical = 12.dp)
        .windowInsetsPadding(WindowInsets.navigationBars),
      horizontalArrangement = Arrangement.SpaceAround,
      verticalAlignment = Alignment.CenterVertically
    ) {
      NavBarItem(icon = Icons.Outlined.Home, label = "Home", isSelected = selectedTab == "Home", onClick = { onTabSelected("Home") })
      NavBarItem(icon = Icons.Outlined.GridView, label = "Projects", isSelected = selectedTab == "Projects", onClick = { onTabSelected("Projects") })
      NavBarItem(icon = Icons.Outlined.Person, label = "About", isSelected = selectedTab == "About", onClick = { onTabSelected("About") })
      NavBarItem(icon = Icons.Outlined.Send, label = "Contact", isSelected = selectedTab == "Contact", onClick = { onTabSelected("Contact") })
    }
  }
}

@Composable
fun NavBarItem(icon: ImageVector, label: String, isSelected: Boolean, onClick: () -> Unit) {
  Column(
    horizontalAlignment = Alignment.CenterHorizontally,
    modifier = Modifier.clickable(onClick = onClick)
  ) {
    Box(
      modifier = Modifier
        .clip(RoundedCornerShape(16.dp))
        .background(
          if (isSelected) MaterialTheme.colorScheme.secondaryContainer else Color.Transparent
        )
        .padding(horizontal = 20.dp, vertical = 6.dp)
    ) {
      Icon(
        imageVector = icon,
        contentDescription = label,
        tint = if (isSelected) MaterialTheme.colorScheme.onSecondaryContainer else MaterialTheme.colorScheme.onSurfaceVariant
      )
    }
    Text(
      text = label,
      style = MaterialTheme.typography.labelSmall,
      color = if (isSelected) MaterialTheme.colorScheme.onBackground else MaterialTheme.colorScheme.onSurfaceVariant,
      modifier = Modifier.padding(top = 4.dp),
      fontWeight = if (isSelected) FontWeight.SemiBold else FontWeight.Medium
    )
  }
}


